package com.example.collection;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceFlowDemo {

    public static void main(String[] args) throws Exception {

        // This is the notification queue.
        ReferenceQueue<User> queue = new ReferenceQueue<>();

        User user = new User("Vinod");

        // weakKey points weakly to user and is registered with queue.
        WeakReference<User> weakKey =
                new WeakReference<>(user, queue);

        System.out.println("========== STAGE 1 ==========");
        System.out.println("Strong variable user : " + user);
        System.out.println("weakKey.get()        : " + weakKey.get());
        System.out.println("queue.poll()         : " + queue.poll());

        /*
         * Put a debugger breakpoint here.
         *
         * At this moment:
         *
         * user ----strong----> User("Vinod")
         * weakKey --weak-----> User("Vinod")
         */
        user = null;

        System.out.println("\n========== STAGE 2 ==========");
        System.out.println("user                 : " + user);
        System.out.println("weakKey.get()        : " + weakKey.get());
        System.out.println("queue.poll()         : " + queue.poll());

        /*
         * user=null does NOT notify the queue.
         *
         * At this moment:
         *
         * weakKey --weak-----> User("Vinod")
         */

        Reference<? extends User> notification = null;

        for (int attempt = 1;
             attempt <= 20 && notification == null;
             attempt++) {

            System.out.println("\nRequesting GC, attempt " + attempt);

            System.gc();
            Thread.sleep(100);

            /*
             * Put a debugger breakpoint here.
             *
             * poll() returns the cleared WeakReference
             * when GC has enqueued it.
             */
            notification = queue.poll();

            System.out.println("weakKey.get() : " + weakKey.get());
            System.out.println("queue.poll()  : " + notification);
        }

        System.out.println("\n========== STAGE 3 ==========");
        System.out.println(
                "Was weakKey itself placed in queue? "
                        + (notification == weakKey)
        );
    }

    static final class User {
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{name='" + name + "'}";
        }
    }
}
