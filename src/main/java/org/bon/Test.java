package org.bon;

import org.bon.api.Class;
import org.bon.api.ClassGroup;
import org.bon.api.Method;
import org.bon.api.containers.Blocks;


public class Test {

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

    public static class Stopwatch {

        private long started = 0;
        private long ended = 0;

        public void start() {
            started = System.currentTimeMillis();
        }

        public void end() {
            ended = System.currentTimeMillis();
        }

        public long getElapsed() {
            if (ended != 0) {
                return ended - started;
            } else if (started != 0) {
                return System.currentTimeMillis() - started;
            } else {
                return 0;
            }
        }

        public static Stopwatch createStarted() {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.start();
            return stopwatch;
        }

        public static Stopwatch createUnstarted() {
            return new Stopwatch();
        }
    }
}
