class Solution {
    public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder diary = new StringBuilder();

        backtrack(digits, 0, map, diary, res);

        return res;
    }
     static void backtrack(String digits, int idx,
                           HashMap<Character, String> map,
                           StringBuilder diary,
                           List<String> res) {

        // Base case
        if (idx == digits.length()) {
            res.add(diary.toString());
            return;
        }

        // Get choices for current digit
        String choice = map.get(digits.charAt(idx));

        // Try all choices
        for (int j = 0; j < choice.length(); j++) {

            // Choose
            diary.append(choice.charAt(j));

            // Explore
            backtrack(digits, idx + 1, map, diary, res);

            // Undo
            diary.deleteCharAt(diary.length() - 1);
        }
    }
}