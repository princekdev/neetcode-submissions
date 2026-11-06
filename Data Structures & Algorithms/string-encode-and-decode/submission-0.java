
class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);

            ans.append(s.length()).append("#").append(s);
        }

        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        while(i < str.length()) {

            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            String s = str.substring(j + 1, j + 1 + len);

            ans.add(s);

            i = j + 1 + len;
        }

        return ans;
    }
}
