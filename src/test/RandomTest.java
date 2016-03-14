import com.parkhomenko.random.CustomGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static junit.framework.Assert.assertTrue;

/**
 * Created by dmitro on 3/9/16.
 */
public class RandomTest {

    @Test
    public void generate_simple_random_int_value() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        assertTrue(randomNumber < 10);

        System.out.println("Test name: generate_simple_random_int_value, result:");
        System.out.println(randomNumber);
    }

    @Test
    public void generate_secure_random() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        int randomNumber = random.nextInt(10);

        assertTrue(randomNumber < 10);

        System.out.println("Test name: generate_secure_random, result:");
        System.out.println(randomNumber);
    }

    @Test
    public void generate_single_random_number() {

        int randomNumber = (int) (Math.random() * 10);

        assertTrue(randomNumber < 10);

        System.out.println("Test name: generate_single_random_number, result:");
        System.out.println(randomNumber);
    }

    @Test
    public void generate_random_number_java8() {
        Random random = new Random(10);
        OptionalInt randomNumber = random.ints(0, 10).findFirst();

        assertTrue(randomNumber.getAsInt() < 10);

        System.out.println("Test name: generate_random_number_java8, result:");
        System.out.println(randomNumber.getAsInt());
    }

    @Test
    public void generate_random_double_stream_java8() {
        Random random = new Random();
        DoubleStream doubleStream = random.doubles();

        System.out.println("Test name: generate_random_double_stream_java8, result:");
        doubleStream.limit(10).forEach(System.out::println);
    }

    @Test
    public void generate_random_int_stream_java8() {
        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        List<Integer> randomElements = intStream
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        assertTrue(randomElements.size() == 10);

        System.out.println("Test name: generate_random_int_stream_java8, result:");
        randomElements.forEach(System.out::println);
    }

    @Test
    public void generate_stream_api_stream_java8() {
        Random random = new Random();
        DoubleStream gaussianStream = Stream.generate(random::nextGaussian).mapToDouble(e -> e);
        List<Double> randomElements = gaussianStream
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        assertTrue(randomElements.size() == 10);

        System.out.println("Test name: generate_stream_api_stream_java8, result:");
        randomElements.forEach(System.out::println);
    }

    @Test
    public void generate_random_uuid() {
        String uuid = UUID.randomUUID().toString();

        assertTrue(!uuid.isEmpty());

        System.out.println("Test name: generate_random_uuid, result:");
        System.out.println(uuid);
    }

    @Test
    public void generate_random_code() {
        final int CODE_LENGTH = 7;
        String code = RandomStringUtils.randomNumeric(CODE_LENGTH);

        assertTrue(!code.isEmpty());

        System.out.println("Test name: generate_random_code, result:");
        System.out.println(code);
    }

    @Test
    public void custom_generator_unique_code() {
        final int CODE_LENGTH = 7;
        Random random = new Random();
        IntStream intStream = random.ints(1000000, 10000000).limit(10);
        Set<String> set = intStream.mapToObj(String::valueOf).collect(Collectors.toSet());
        CustomGenerator<String> generator = new CustomGenerator<>();
        String uniqueCode = generator.generateUniqueCode(() -> RandomStringUtils.randomNumeric(CODE_LENGTH), set::contains);

        assertTrue(!uniqueCode.isEmpty());

        System.out.println("custom_generator_unique_code");
        System.out.println(uniqueCode);
    }

}
