public class FifthTask {
    public static String Exec(int number){
        if (number < 100000 || number > 999999) {
            return "Шеф, усе втрачено!!!";
        }

        int firstPart = number / 1000;
        int secondPart = number % 1000;

        if (sumDigits(firstPart) == sumDigits(secondPart)) {
            return "Урааааа";
        } else {
            // Обробка числа за умовою
            int[] digits = new int[6];
            for (int i = 5; i >= 0; i--) {
                digits[i] = number % 10;
                number /= 10;
            }

            digits[0] += 1;
            digits[2] += 1;
            digits[5] += 1;

            digits[1] /= 2;
            digits[3] /= 2;
            digits[4] /= 2;

            StringBuilder result = new StringBuilder();
            for (int digit : digits) {
                result.append(digit);
            }

            return result.toString();
        }
    }

    private static int sumDigits(int part) {
        int sum = 0;
        while (part > 0) {
            sum += part % 10;
            part /= 10;
        }
        return sum;
    }
    }
