package vsu.negulyaevPavelNikolaevich;

import vsu.negulyaevPavelNikolaevich.util.ArrayUtils;
import vsu.negulyaevPavelNikolaevich.util.SwingUtils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        winMain();
    }
    public static void winMain() {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
    private static void runCmd() throws IOException {
        CmdCommands cmdCommand = CmdCommands.STATIC;
        Scanner scanner = new Scanner(System.in);

        String command;
        String inputFile;
        String outputFile = "-";

        List<Integer> list = Arrays.asList(3, 4, 9);
        Data tempStorage = new Data();
        int index1 = 0;
        int index2 = 2;
        int[] arr;
        arr = Logic.listToArr(list);

        System.out.println("Commands:");
        System.out.println("-run     - run program");
        System.out.println("-help    - show commands");
        System.out.println("-exit    - close program");
        System.out.println("-read    - read array from console");
        System.out.println("-input   - enter way to input file");
        System.out.println("-output  - enter way to output file");

        while (cmdCommand != CmdCommands.EXIT) {
            command = scanner.next();
            if (Objects.equals(command, "-run")) {
                cmdCommand = CmdCommands.RUN;
            } else if (Objects.equals(command, "-help")) {
                cmdCommand = CmdCommands.HELP;
            } else if (Objects.equals(command, "-exit")) {
                cmdCommand = CmdCommands.EXIT;
            } else if (Objects.equals(command, "-read")) {
                cmdCommand = CmdCommands.READ_FROM_CONSOLE;
            } else if (Objects.equals(command, "-input")) {
                cmdCommand = CmdCommands.ENTER_INPUT_FILE;
            } else if (Objects.equals(command, "-output")) {
                cmdCommand = CmdCommands.ENTER_OUTPUT_FILE;
            } else if (Objects.equals(command, "-index")){
                cmdCommand = CmdCommands.READ_INDEXES_FROM_CONSOLE;
            }
            else {
                System.out.println("Error, this command is not found. Try again: ");
            }

            switch (cmdCommand) {
                case EXIT -> System.exit(1);
                case RUN -> {
                    Logic.printCollection(list);
                    Logic.sort(list, index1, index2);
                    arr = Logic.listToArr(list);
                    if (!Objects.equals(outputFile, "-")) {
                        ArrayUtils.writeArrayToFile(outputFile, arr);
                    }
                    System.out.println("====================================");
                    Logic.printCollection(list);
                }
                case READ_FROM_CONSOLE -> {
                    list = Logic.arrToList(ArrayUtils.readIntArrayFromConsole());
                    System.out.println("Array updated");
                }
                case READ_INDEXES_FROM_CONSOLE -> {
                    System.out.print("Enter index1: ");
                    index1 = scanner.nextInt();
                    System.out.print("Enter index2: ");
                    index2 = scanner.nextInt();
                    System.out.println("Indexes updated.");
                }
                case ENTER_INPUT_FILE -> {
                    System.out.print("Enter way to input file: ");
                    inputFile = scanner.next();
                    list = Logic.arrToList(Logic.readIntArrayFromFile(inputFile));
                    System.out.println("Array updated.");
                }
                case ENTER_OUTPUT_FILE -> {
                    System.out.print("Enter way to output file: ");
                    outputFile = scanner.next();
                }
                case HELP -> {
                    System.out.println("Commands:");
                    System.out.println("-run     - run program");
                    System.out.println("-help    - show commands");
                    System.out.println("-exit    - close program");
                    System.out.println("-read    - read array from console");
                    System.out.println("-input   - enter way to input file");
                    System.out.println("-output  - enter way to output file");
                    System.out.println("-index   - enter indexes");
                }
            }

        }
    }
}
