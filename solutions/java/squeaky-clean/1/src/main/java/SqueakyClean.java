class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (i < identifier.length()) {
            char current = identifier.charAt(i);
            if (current == '-') {
                if (i + 1 < identifier.length()) {
                    char next = identifier.charAt(i + 1);
                    builder.append(Character.toUpperCase(next));
                    i += 2;
                } else {
                    i++;
                }
                continue;
            }
            if (current == ' ') {
                builder.append('_');
                i++;
                continue;
            }

            if (Character.isISOControl(current)) {
                builder.append("CTRL");
                i++;
                continue;
            }

            if (isLeet(current)) {
                builder.append(convertLeet(current));
                i++;
                continue;
            }

            if (isGreekLowercase(current)) {
                i++;
                continue;
            }

            if (Character.isLetter(current) || current == '_') {
                builder.append(current);
                i++;
                continue;
            }

            i++;
        }

        return builder.toString();
    }

    private static boolean isGreekLowercase(char c) {
        return c >= '\u0370' && c <= '\u03FF' && Character.isLowerCase(c);
    }

    private static boolean isLeet(char c) {
        return c == '4' || c == '3' || c == '0' || c == '1' || c == '7';
    }

    private static char convertLeet(char c) {
        switch (c) {
            case '4': return 'a';
            case '3': return 'e';
            case '0': return 'o';
            case '1': return 'l';
            case '7': return 't';
            default: return c;
        }
    }
}