class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
       

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

            if((right - left + 1) == p.length()){

                if(map.equals(map1)){
                    list.add(left);
                }

                char remove = s.charAt(left);

                map1.put(remove, map1.getOrDefault(remove, 0) - 1);

                if(map1.get(remove) == 0){
                    map1.remove(remove);
                }
                left++;
            }
        }
        return list;
    }
}