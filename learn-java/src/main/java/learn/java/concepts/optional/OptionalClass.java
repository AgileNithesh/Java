package learn.java.concepts.optional;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalClass {

    /**
     * Optional
     * <p>
     * - Without optional client was forced to add repetitive null checks extensively
     * to avoid NullPointerException when the response may or may not contain null
     *
     * Where not to use optional
     *  - Class Variable -- bad design bcz pojo classes expected to have simple return
     *                      values to work seamlessly with frameworks like lombok, jackson
     *
     * - Method Parameter -- in this case user might pass null with prompts null check for Optional haha.
     * - Serializable class -- Json serializable pojo classes
     * - DAO class methods -- not recommended where a null value in column get's converted
     *                        into NULL then optional empty.
     *
     * Best places
     *  - Service layer -- to handle data in business logic
     *
     *
     */

    static void main() {

        optionalCreation();
        optionValueCheck();
        optionalRetrieve();
        optionalValueTransform();
        optionalActions();
        optionalStreamIntegration();

    }

    // to convert optional into stream
    // this is useful when optional used to check inside stream operations
    private static void optionalStreamIntegration() {

        Optional.of("Nithesh").stream().forEach(IO::println);

       List<User> userList = Arrays.asList(
               new User("Nithesh"),
               new User("Kumar"),
               new User("Trader"),
               new User("Billionaire")
       );

       // usage
       List<String> names = userList.stream()
               .map((user) -> user.getName())
               .flatMap((Optional<String> name) -> name.stream())
               .collect(Collectors.toList());

       IO.println(names);

    }

    private static void optionalActions() {

        Optional<String> opNithesh = Optional.of("Nithesh");

        // ifPresent
        opNithesh.ifPresent((val) -> {
            IO.println("if present " + val);
        });

        // ifPresentOrElse
        opNithesh.ifPresentOrElse((val) -> {
                    IO.println("present " + val);
                },
                () -> {
                    IO.println("not present");
                });

        // or()
        Optional<String> orOptional = opNithesh.or(() -> Optional.of("Default"));



    }


    private static void optionalValueTransform() {

        /**
         * map()
         * - used to transform an element
         *
         */

        Optional<String> opNithesh = Optional.of("Nithesh");
        Optional<Integer> opInteger = opNithesh.map((val) -> {
            return val.length();
        });
        IO.println(opInteger.get());

        // problem with flatmap is the nested Optional
        Optional<Optional<Integer>> nestedOptional = opNithesh.map((val) -> {
            return Optional.of(val.length());
        });

        // flatMap() -- to mitigate the problem with map()
        Optional<Integer> flatmapOptional = opNithesh.flatMap((val) -> {
            return Optional.of(val.length());
        });


        // filter() -- keeps optional value if matches condition or else returns empty
        Optional<String> filterOp = opNithesh.filter((val) -> {
            return val.equals("Nithesh");
        });


    }

    private static void optionalRetrieve() {

        User u = new User();
        u.setName("a");

        Optional<String> username = Optional.of(String.valueOf(u.getName()));

        // get()
        if (username.isPresent()) {
            IO.println(username.get());
        }

        // orElse -- to send a default if null
        IO.println(username.orElse("no name"));

        username = Optional.empty();
        // orElseGet -- when default value requires custom computation
        IO.println(username.orElseGet(() -> "okay "));

        // orElseThrow
        try {
            username.orElseThrow();
        } catch (Exception e) {
            IO.println("Exception");
        }

        // orElseThrow
        try {
            username.orElseThrow(() -> new RuntimeException());
        } catch (Exception e) {
            IO.println("Exception");
        }

    }

    private static void optionValueCheck() {

        User u = new User();
        u.setName("a");

        Optional<String> username = Optional.of(String.valueOf(u.getName()));

        // to check if the values is present
        if (username.isPresent()) {
            IO.println("present");
        }

        // to check if empty
        boolean empty = username.isEmpty();


    }


    private static void optionalCreation() {

        User u = new User();
        u.setName("a");

        // of, throws null pointer if the object is null
        Optional<String> username = Optional.of(String.valueOf(u.getName()));

        // ofNullable, returns static empty optional instance
        username = Optional.ofNullable(String.valueOf(u.getName()));

        // to get the static empty optional instance
        Optional<String> emptyOptional = Optional.empty();

    }


    private static class User {
        String name;

        public User(String name){
            this.name = name;
        }

        public User() {

        }

        public Optional<String> getName() {
            return Optional.of(name);
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
