class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression, new int[]{0});
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s, int[] i) {
        Set<String> res = new HashSet<>();
        res.add("");

        while (i[0] < s.length() && s.charAt(i[0]) != '}') {
            Set<String> cur;

            if (s.charAt(i[0]) == '{') {
                i[0]++;
                cur = parse(s, i);
                i[0]++;
            } else {
                cur = new HashSet<>();
                cur.add(String.valueOf(s.charAt(i[0]++)));
            }

            Set<String> next = new HashSet<>();

            for (String a : res) {
                for (String b : cur) {
                    next.add(a + b);
                }
            }

            res = next;

            if (i[0] < s.length() && s.charAt(i[0]) == ',') {
                i[0]++;
                res.addAll(parseUnion(s, i));
                break;
            }
        }

        return res;
    }

    private Set<String> parseUnion(String s, int[] i) {
        Set<String> res = new HashSet<>();

        while (i[0] < s.length() && s.charAt(i[0]) != '}') {
            res.addAll(parse(s, i));

            if (i[0] < s.length() && s.charAt(i[0]) == ',') {
                i[0]++;
            } else {
                break;
            }
        }

        return res;
    }
}