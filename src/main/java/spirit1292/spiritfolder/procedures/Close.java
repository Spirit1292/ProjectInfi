package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import javax.swing.*;

public class Close
{
    public static void main(String[] args)
    {
        int i = JOptionPane.showConfirmDialog(
                null,
                TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_1,
                TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_TITLE,
                JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        switch (i)
        {
            case JOptionPane.YES_OPTION:
            {
                System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_PROCEDURE_CLOSE_EXIT_MESSAGE);
                System.exit(0);
            }
            case JOptionPane.NO_OPTION:
            {
                Object[] options = {TerminalMessages.TITLE_PROCEDURE_CLOSE_ANSWER_2};
                int j = JOptionPane.showOptionDialog(
                        null,
                        TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_2,
                        TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_TITLE,
                        JOptionPane.YES_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);
            }
        }
    }
}
