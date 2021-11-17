import java.io.File;

public class Main {
    public static void main(String[] args) {
        // get filename from args - if none provided, prompt user and exit
        String filename;
        if(args.length > 0) {
            filename = args[0];
        } else {
            System.out.println("No filename was supplied.");
            return;
        }

        // check filename has extension
        if(!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        // check the file exists
        File file = new File(filename);
        if(!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
    }
}
