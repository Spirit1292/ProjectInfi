package main.java.spirit1292.spiritfolder.settings;

import com.sun.org.apache.xerces.internal.dom.DOMImplementationImpl;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

public final class AppConfig
{
    private HashMap fHashMap;

    private AppConfig()
    {
        fHashMap = new HashMap();
    }

    private static AppConfig SINGLETON;
    static
    {
        SINGLETON = new AppConfig();
    }

    public static Object get(String key)
    {
        return SINGLETON.fHashMap.get(key);
    }

    public static Object get(String key, Object deflt)
    {
        try
        {
            Object obj = SINGLETON.fHashMap.get(key);
            if (obj == null)
            {
                new Message().ShowMessage(1, 1, TerminalMessages.TITLE_SETTINGS_LOAD_DEFAULT_DONE
                        + ": " + deflt, false);
                return deflt;
            }
            else
            {
                return obj;
            }
        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_SETTINGS_LOAD_ERROR, true);
            return null;
        }
    }

    public static int getInt(String key, int deflt)
    {
        try
        {
            Object obj = SINGLETON.fHashMap.get(key);
            if (obj == null)
            {
                new Message().ShowMessage(1, 1, TerminalMessages.TITLE_SETTINGS_LOAD_DEFAULT_DONE
                        + ": " + deflt, false);
                return deflt;
            }
            else
            {
                return Integer.parseInt((String) obj);
            }
        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_SETTINGS_LOAD_ERROR, true);
            return -1;
        }
    }

    public static boolean getBoolean(String key)
    {
        try
        {
            Object obj = SINGLETON.fHashMap.get(key);
            return Boolean.parseBoolean((String) obj);
        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_SETTINGS_LOAD_ERROR, true);
            return false;
        }
    }

    public static void clear()
    {
        SINGLETON.fHashMap.clear();
    }

    public static void put(String key, Object data)
    {
        if (data == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            SINGLETON.fHashMap.put(key, data);
        }
    }

    public static boolean save(File file) throws Exception
    {
        try
        {
            DOMImplementation domImpl = new DOMImplementationImpl();
            Document doc = domImpl.createDocument(null, "app-settings", null);
            Element root = doc.getDocumentElement();
            Element propertiesElement = doc.createElement("properties");
            root.appendChild(propertiesElement);
            Set set = SINGLETON.fHashMap.keySet();
            for (Object aSet : set) {
                String key = aSet.toString();
                Element propertyElement = doc.createElement("property");
                propertyElement.setAttribute("key", key);
                Text nameText = doc.createTextNode(get(key).toString());
                propertyElement.appendChild(nameText);
                propertiesElement.appendChild(propertyElement);
            }
            DOMSerializer serializer = new DOMSerializer();
            serializer.serialize(doc, file);
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_SETTINGS_SAVE_DONE, false);
            return true;
        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_SETTINGS_SAVE_ERROR, true);
            return false;
        }
    }

    public static boolean load(File file) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        if (doc == null)
        {
            throw new NullPointerException();
        }
        NodeList propertiesNL = doc.getDocumentElement().getChildNodes();
        if (propertiesNL != null)
        {
            for (int i = 0; (i < propertiesNL.getLength()); i++)
            {
                if (propertiesNL.item(i).getNodeName().equals("properties"))
                {
                    NodeList propertyList = propertiesNL.item(i).getChildNodes();
                    for (int j = 0; j < propertyList.getLength(); j++)
                    {
                        NamedNodeMap attributes = propertyList.item(j).getAttributes();
                        if (attributes != null)
                        {
                            Node n = attributes.getNamedItem("key");
                            NodeList childs = propertyList.item(j).getChildNodes();
                            if (childs != null) {
                                for (int k = 0; k < childs.getLength(); k++)
                                {
                                    if (childs.item(k).getNodeType() == Node.TEXT_NODE)
                                    {
                                        put(n.getNodeValue(), childs.item(k).getNodeValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
