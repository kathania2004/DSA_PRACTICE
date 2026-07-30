class Solution {
    public boolean isValid(String s) {
        Stack<Character> h = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                h.push(ch);
            } else {
                if (h.isEmpty()) {
                    return false;
                }

                char top = h.peek();

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    h.pop();
                } else {
                    return false;
                }
            }
        }

        return h.isEmpty();
    }
}