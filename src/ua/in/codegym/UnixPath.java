package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 04.05.2016.
 */
public class UnixPath {

    public String simplify(String input) {

        //Максимальная длина пути в UNIX
        if (input.length() > 4096){
            return "/";
        }

        String[] arrayPath = input.split("/");
        List<String> simplePathList = new ArrayList<>();

        for (int i = 0; i < arrayPath.length; i++) {
            if (arrayPath[i].equals("..")) {
                simplePathList.remove(simplePathList.size() - 1);
                continue;
            }
            if (!arrayPath[i].equals("") && !arrayPath[i].equals(".")) {
                simplePathList.add(arrayPath[i]);
            }
        }

        StringBuilder simplePath = new StringBuilder();

        do {
            simplePath.append("/");
            if (simplePathList.size() > 0) {
                simplePath.append(simplePathList.get(0));
                simplePathList.remove(0);
            }
        } while (simplePathList.size() > 0);

        return simplePath.toString();
    }
}
