package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import javax.swing.*;

public class Close
{
    public static void main(String[] args)
    {
        int i = JOptionPane.showConfirmDialog(
                null,
                TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_FIRST,
                TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_TITLE,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        switch (i)
        {
            case JOptionPane.YES_OPTION:
            {
                new Message().ShowMessage(1, 3, TerminalMessages.TITLE_PROCEDURE_CLOSE_MESSAGE, false);
                try
                {
                    Thread.sleep(1000);
                    System.exit(0);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            case JOptionPane.NO_OPTION:
            {
                Object[] options = {TerminalMessages.TITLE_PROCEDURE_CLOSE_ANSWER_SECOND};
                JOptionPane.showOptionDialog(
                        null,
                        TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_SECOND,
                        TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_TITLE,
                        JOptionPane.OK_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);
            }
        }
    }
}
