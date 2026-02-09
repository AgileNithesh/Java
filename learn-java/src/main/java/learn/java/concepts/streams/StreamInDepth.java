package learn.java.concepts.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInDepth {

    /**
     *
     * Stream
     * <p>
     * - Consider as a pipeline through with collection elements passes through
     * - useful when dealing with bulk processing ( parallel processing )
     * - 3 Steps
     * - 1. Create a stream from collections
     * - 2. Intermediate operations filter(), sort(), map(), distinct() ... etc.
     * Transforms one stream to another stream. Lazy in nature means
     * these operations get executed only when terminal operation is
     * invoked. Can use one or more operations.
     * - 3. Terminal operations collect(), reduce() ... etc. Only one operation
     * can be performed, it closes the stream and returns a new collection.
     * These operations trigger the processing of stream
     * <p>
     *
     * - Once terminal operation is used, the stream gets closed, and it cannot be
     * consumed again - this will result in runtime exception
     *
     */


    static void main() {

        //streamSalary();
        //intermediateOperations();
        //whyLazy();
        //sequenceCheck();
        //terminalOperations();
        parallelStream();

    }

    // to take advantage of multicore cpu for optimal performance
    // uses fork-join pool technique
    private static void parallelStream() {

        List<Integer> nums = Arrays.asList(1, 34, 54, 456, 564, 223, 23, 23352, 5, 25252,
                2, 2, 323, 34, 34, 34536, 56456, 456, 4, 5454453, 45, 25, 25, 24, 52,
                52, 32, 45, 453, 45, 345, 34, 54, 52, 45, 245, 2, 35, 235, 2);


        long seqTime = System.currentTimeMillis();
        //Sequential
        nums.stream()
                .map(val -> val * 10)
                .filter(val -> val > 100)
                .map((val) -> {
                            for (int i = 0; i < 99999999; i++) {
                                for (int j = 0; j < 99999999; j++) {
                                    int k = 0;
                                }
                            }
                            return true;
                        }
                )
                .count();
        IO.println("sequential operation time - " + (System.currentTimeMillis() - seqTime));

        long parallelTime = System.currentTimeMillis();
        //parallel
        nums.parallelStream()
                .map(val -> val * 10)
                .filter(val -> val > 100)
                .map((val) -> {
                            for (int i = 0; i < 99999999; i++) {
                                for (int j = 0; j < 99999999; j++) {
                                    int k = 0;
                                }
                            }
                            return true;
                        }
                )
                .count();
        IO.println("parallel stream operation time - " + (System.currentTimeMillis() - parallelTime));


    }

    private static void terminalOperations() {

        List<Integer> numbs = Arrays.asList(2, 1, 4, 7, 10);

        // foreach
        numbs.stream().filter(val -> val > 3).forEach(IO::println);

        // toArray
        numbs.stream().toArray();

        // reduce - reduction on the elements. Perform associative aggregation function
        Optional<Integer> reducedValue = numbs.stream().reduce((val1, val2) -> val1 + val2);
        IO.println(reducedValue.get()); // output is 24 -- addition of all elements

        // collect the resultant stream
        IO.println(numbs.stream().collect(Collectors.toList()));

        // min max
        IO.println(numbs.stream().min((v1, v2) -> v1 - v2).get()); // 1

        IO.println(numbs.stream().max((v1, v2) -> v1 - v2).get()); // 10

        // any match
        IO.println(numbs.stream().anyMatch(val -> val > 4));

    }

    private static void sequenceCheck() {

        List<Integer> numbs = Arrays.asList(2, 1, 4, 7, 10);

        Stream<Integer> numStream = numbs.stream()
                .filter(val -> val > 3)
                .peek(val -> IO.println("After filer - " + val))
                .map(val -> val * 10)
                .peek(val -> IO.println("After Map - " + val))
                .sorted()
                .peek(val -> IO.println("After Sorted - " + val));

        /**
         *
         * Below is the output of above statement, sorted operation executed only
         * after other operations since it requires complete modified data before
         * processing.
         *
         * After filer - 4
         * After Map - 40
         * After filer - 7
         * After Map - 70
         * After filer - 10
         * After Map - 100
         * After Sorted - 40
         * After Sorted - 70
         * After Sorted - 100
         * [40, 70, 100]
         *
         */

        IO.println(numStream.toList());

    }

    private static void whyLazy() {

        List<Integer> numbs = Arrays.asList(324, 122, 45, 5, 56);

        // this won't print since terminal operation is invoked
        Stream<Integer> numStream = numbs.stream().filter(val -> val > 20).peek(IO::println);

        // without invoking terminal the above filter and peek won't get executed since it is lazy
        numStream.count();

    }

    private static void intermediateOperations() {

        Stream<String> strStream = Stream.of("Hi ", "There", "JP", "Morgan", "I'm coming!!");

        // filter the stream
        Stream<String> filerstrStream = strStream.filter(name -> name.length() > 3);

        List<String> filteredName = filerstrStream.collect(Collectors.toList());
        IO.println(filteredName);

        // map transforms each element
        Stream<String> mapStream = Stream.of("Hi ", "There", "JP", "Morgan", "I'm coming!!");
        Stream<String> modifyMapStream = mapStream.map((String name) -> name.toUpperCase());
        IO.println(modifyMapStream.toList());

        // flatmap - flattens a complex collection
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("The great businessman Nithesh".split(" ")),
                Arrays.asList("The Billionaire Nithesh".split(" ")),
                Arrays.asList("It Is Happening".split(" "))
        );

        IO.println(sentenceList);

        // converts it to one 1d list
        Stream<String> nitheshStream = sentenceList.stream().flatMap(
                (List<String> sentence) -> sentence.stream().map(String::toUpperCase));
        IO.println(nitheshStream.toList());
        // [THE, GREAT, BUSINESSMAN, NITHESH, THE, BILLIONAIRE, NITHESH, IT, IS, HAPPENING]


        // distinct -- removes duplicates
        Integer[] numbers = {21, 32, 43, 121, 23, 12, 21, 44, 55, 66, 77, 44};
        IO.println(Arrays.stream(numbers).distinct().toList());

        // sort - can pass lambda exp for descending order
        IO.println(Arrays.stream(numbers).sorted().toList());

        // peek
        List<Integer> peekList = Arrays.stream(numbers)
                .filter((Integer val) -> val > 30)
                .peek(IO::println)
                .map((Integer val) -> val * 10).toList();
        IO.println(peekList);


        // limit - truncate the list to given max size
        IO.println(Arrays.stream(numbers).limit(5).toList());

        // skip - skips first n elements
        IO.println(Arrays.stream(numbers).skip(5).toList());

        // mapToInt
        String[] numString = {"2", "43", "1243"};
        int[] numArray = Arrays.stream(numString).mapToInt(Integer::parseInt).toArray();
        IO.println(Arrays.toString(numArray));

    }

    static void streamSalary() {

        List<Integer> salary = new ArrayList<>();

        salary.add(28000);
        salary.add(72819);
        salary.add(243235);
        salary.add(22234);

        // count salaries greater than 30000
        long count = salary.stream().filter((Integer sal) -> sal > 30000).count();
        IO.println(count);

        // ways to create
        Stream<Integer> streamSalary = salary.stream();

        Integer[] intArray = {1000, 32030, 2103};

        streamSalary = Arrays.stream(intArray);

        streamSalary = Stream.of(1200, 123, 1231, 123);

        streamSalary = Stream.iterate(100, n -> n + 100).limit(20);


        // Stream Builder

        Stream.Builder<Integer> sreBuilder = Stream.builder();
        Stream<Integer> builder = sreBuilder.add(1000).add(23829).add(2183).build();


    }

}
