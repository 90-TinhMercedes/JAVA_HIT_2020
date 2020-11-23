package Demo;

import java.util.*;

public class RunMain {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();

//        list.add("GFE");
//        list.add("Love");
//        list.add("Veigar");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next()); // sau khi in sẽ dịch sang phần tử tiếp theo
//        }

//        //Linked list
//        list = new LinkedList<>();
//        list.add("GFE");
//        list.add("Love");
//        list.add("Veigar");
//        System.out.println(list.get(2));

//        list = new Vector<>();
//        list = new Stack<>(); // vào sau ra trước



//        Queue<String> queue = new LinkedList<>();     // Ngược lại với Stack
//        queue.add("Như Ý");
//        queue.add("Văn Phòng Phẩm");
////        queue.remove();
//        for(String s : queue){
//            System.out.println(s);
//        }



//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "Như Ý");
//        map.put(2, "Chí Tình");
//        //map.put(2, "VPP"); // ghi đè
//        for(Map.Entry<Integer, String> s : map.entrySet()){
//            System.out.println(s.getKey() + ": " + s.getValue());
//        }


        Set<String> set = new HashSet<>();
//        Set<String> set = new TreeSet<>();
        set.add("Chí Tình");
        set.add("HaUI");
        set.add("Chí Tình");
        set.add("HaUI ver 02");

        for (String s : set){
            System.out.println(s);
        }

    }
}
