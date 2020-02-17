package org.bon;

import org.bon.api.Class;
import org.bon.api.ClassGroup;
import org.bon.api.Method;
import org.bon.api.containers.Blocks;


public class test {

    public static void main(String[] args) throws Exception {
        ClassGroup classGroup = ClassGroup.from("./181.jar");
        for (Class c : classGroup.getClasses()) {
            for (Method method : c.getMethods()) {
                Blocks blocks = method.getBlocks();
                for (int i = 0; i < blocks.size(); i++) {
                    System.out.println(blocks.get(i).getTargetOf().size());
                }
            }
        }
    }
}
