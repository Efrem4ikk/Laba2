package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.List;

public class Uniq {
    private final boolean i_Flag;
    private final boolean u_Flag;
    private final boolean c_Flag;
    private final int s_Num;
    private final String o_File;
    private final String i_File;
    private List<String> lines;
    private List<String> result;

    public Uniq(boolean i_Flag, boolean u_Flag, boolean c_Flag, int s_Num, String o_File, String i_File) {
        this.i_Flag = i_Flag;
        this.u_Flag = u_Flag;
        this.c_Flag = c_Flag;
        this.s_Num = s_Num;
        this.o_File = o_File;
        this.i_File = i_File;
    }

    public List<String> make_uniq() throws IOException {
        result = new ArrayList<>();
        lines = Files.readAllLines(Paths.get(i_File));
        basis();
        if (o_File != null) {
            Path outfile = Paths.get(o_File);
            Files.write(outfile, result);
        } else {
            System.out.println(result);
        }
        return result;
    }

    private boolean is_Str_Eq_Prev(int i) {
        boolean equals;
        if (s_Num != 0 && i_Flag)
            equals = lines.get(i).substring(s_Num).equalsIgnoreCase(lines.get(i - 1).substring(s_Num));
        else if (s_Num != 0)
            equals = lines.get(i).substring(s_Num).equals(lines.get(i - 1).substring(s_Num));
        else if (i_Flag)
            equals = lines.get(i).equalsIgnoreCase(lines.get(i - 1));
        else
            equals = lines.get(i).equals(lines.get(i - 1));
        return equals;
    }

    private void basis() {
        int counter = 1;
        for (int i = 1; i < lines.size(); i++) {
            if (is_Str_Eq_Prev(i)) {
                counter++;
                if (i == lines.size() - 1) {
                    if (c_Flag) result.add(counter + lines.get(i));
                    else result.add(lines.get(i));
                }
            } else {
                if (u_Flag && counter == 1)
                    result.add(lines.get(i - 1));
                else if (c_Flag) {
                    if (counter > 1)
                        result.add(counter + lines.get(i - 1));
                    else
                        result.add(lines.get(i - 1));
                } else if(!u_Flag) result.add(lines.get(i - 1));
                counter = 1;
                if (i == lines.size() - 1)
                    result.add(lines.get(i));
            }
        }
    }
}
