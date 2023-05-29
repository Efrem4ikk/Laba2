package org.example;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Main {
    @Option(name = "-i", usage = "Следует не учитывать регистр символов")
    private boolean i_Flag;
    @Option(name = "-u", usage = "Следует выводить в качестве результата только уникальные строки", forbids = {"-c"})
    private boolean u_Flag;
    @Option(name = "-c", usage = "Перед каждой строкой вывода следует вывести количество строк, которые были заменены данной", forbids = {"-u"})
    private boolean c_Flag;
    @Option(name = "-s", usage = "Следует игнорировать первые N символов каждой строки")
    private int s_Num;
    @Option(name = "-o", usage = "имя выходного файла")
    private String o_File;
    @Argument
    private String i_File;

    public static void main(String[] args) throws IOException, CmdLineException {
        new Main().parseArguments(args);
    }

    public Uniq parseArguments(String[] args) throws CmdLineException, IOException {
        CmdLineParser parsing = new CmdLineParser(this);
        try {
            parsing.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.print("Error");
            System.err.println(e.getMessage());
            throw e;
        }
        Uniq uniq = new Uniq(i_Flag, u_Flag, c_Flag, s_Num, o_File, i_File);
        uniq.make_uniq();
        return uniq;
    }
}