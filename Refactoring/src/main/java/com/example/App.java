package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Cat> list = new ArrayList<>();
        List<BreedType> breedTypes;
        breedTypes = Arrays.asList(BreedType.values());
        for (int i = 0; i < 98; i++) {
            Cat cat = new Cat();
            list.add(cat);
            list.get(i).setName("cat" + i);
            list.get(i).setBreed(breedTypes.get(i));
        }
        List<BreedType> newBreedTypes = list.stream().filter(t -> t
                .getBreed().toString().startsWith("A") || t
                .getBreed().toString().startsWith("C") || t
                .getBreed().toString().startsWith("P"))
                .filter(t -> Integer.parseInt(t.getName().substring(3)) % 2 == 0)
                .map(t -> t.getBreed()).collect(Collectors.toList());
        for (BreedType breedType : newBreedTypes) {
            System.out.println(breedType);
        }
    }
}
