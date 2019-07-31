package cn.ben.test.demo;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author yangkun
 * @see
 * @since
 */
public class FakerTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Faker faker = new Faker(Locale.CHINA);
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            names.add(faker.name().name());
            names.add(faker.address().city());
            names.add(faker.phoneNumber().cellPhone());
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i));
            if (i % 3 == 0)
                System.out.println();
        }
    }
}
