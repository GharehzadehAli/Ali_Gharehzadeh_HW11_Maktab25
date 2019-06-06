package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static List<Cat> createCats() {
        List<Cat> list = new ArrayList<>();
        for (int i = 0; i < 98; i++) {
            Cat cat = new Cat();
            list.add(cat);

        }
        return list;
    }

    public static void setCatNames(List<Cat> list) {
        for (int i = 0; i < 98; i++) {
            list.get(i).setName("cat" + i);
        }
    }

    public static void setCatBreeds(List<Cat> list) {
        List<BreedType> breedTypes = Arrays.asList(BreedType.values());
        for (int i = 0; i < 98; i++) {
            list.get(i).setBreed(breedTypes.get(i));
        }

    }

    public static void printBreedType(List<BreedType> newBreedTypes) {
        for (BreedType breedType : newBreedTypes) {
            System.out.println(breedType);
        }
    }

    public static Predicate<Cat> isStartingWithA() {
        Predicate<Cat> startsWithA = t -> t.getBreed().toString().startsWith("A");
        return startsWithA;
    }

    public static Predicate<Cat> isStartingWithC() {
        Predicate<Cat> startsWithC = t -> t.getBreed().toString().startsWith("C");
        return startsWithC;
    }

    public static Predicate<Cat> isStartingWithP() {
        Predicate<Cat> startsWithP = t -> t.getBreed().toString().startsWith("P");
        return startsWithP;
    }
    public static Predicate<Cat> isBreedSuitable(){
        Predicate<Cat> breedCheck = isStartingWithA().or(isStartingWithC().or(isStartingWithP()));
        return breedCheck;
    }
    public static Predicate<Cat> isIndexSuitable(){
        Predicate<Cat> indexCheck = t -> Integer.parseInt(t.getName().substring(3)) % 2 == 0;
        return indexCheck;
    }

    public static Function<Cat,BreedType> mapCatToItsBreed(){
        Function<Cat, BreedType> catToItsBreed = t -> t.getBreed();
        return catToItsBreed;
    }
    public static List<BreedType> generateNewBreedTypeList(List<Cat> list){
        List<BreedType> newBreedTypes = list
                .stream()
                .filter(isBreedSuitable())
                .filter(isIndexSuitable())
                .map(mapCatToItsBreed())
                .collect(Collectors.toList());
        return newBreedTypes;
    }
    public static void main(String[] args) {
        List<Cat> list = createCats();
        setCatNames(list);
        setCatBreeds(list);
        printBreedType(generateNewBreedTypeList(list));
    }
}
