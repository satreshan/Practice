package practice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Start {
    public static void main(String args[]) throws IOException, JsonMappingException {

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(4));
        System.out.println("Hello");
        int[] a = {1,2,3,4};
        int[] b = new int[10];
        System.out.println(Arrays.stream(a).filter(a0 -> a0<3).count());
        List<String> la =
                Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.toList());
        la.stream().forEach(System.out::println);

        //Optional
        Optional<String> s = Optional.ofNullable(null);
        System.out.println(s.orElse("Default"));
        s = Optional.ofNullable("Shalini");
        System.out.println(s.orElse("Default"));

        //File API writeString() readString()
        Path path = Files.writeString(Files.createTempFile("temp",".txt"), "This is to test file aPI");
        String s1 = Files.readString(path);
        System.out.println(s1);

        //String split
        System.out.println("codeSystemURL".split("\\|")[0]);

        //rotated string
        String str = "abc";
        str = str + str;
        String g = "bca";
        System.out.println("Can Roatate: " + str.contains(g));

        char[] carr = {'a', 'b', 'c'};
        System.out.println("Char array to str: " + new String(carr));

        Integer intWrapper = 10;
        System.out.println(intWrapper.intValue());

        int intPrim = 10;
        System.out.println(Integer.valueOf(intPrim));
        System.out.println(Integer.parseInt("1"));

        //Priority queue functionality
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1,b1) -> {return a1-b1;}); //maintain ascending order..min
        // heap
        pq.add(8);
        pq.add(6);
        pq.add(9);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());

        //Array initial default values
        boolean arrbool[] = new boolean[2];
        int aarInt[] = new int[2];
        String strarr[] = new String[2];
        System.out.println("boolean default: " + Arrays.toString(arrbool));
        System.out.println("int default: " + Arrays.toString(aarInt));
        System.out.println("String default: " + Arrays.toString(strarr));

        Set<Integer> setInt = new HashSet<>();
        setInt.add(10);
        setInt.add(11);
        setInt.add(12);
        setInt.removeAll(setInt);
        System.out.println( "Removed all element: " + setInt.isEmpty());

        String words = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] arrWords = words.split(" ");
        System.out.println(Arrays.toString(arrWords));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toString());
    }
}
