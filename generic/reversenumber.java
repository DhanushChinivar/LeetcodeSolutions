class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before multiplying
            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;

            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}
/* 
 In Java, int is 32-bit signed, meaning it can only store numbers between:

Integer.MIN_VALUE = -2,147,483,648
Integer.MAX_VALUE =  2,147,483,647


If the result goes beyond that — either too positive or too negative —
Java wraps around silently (no error, but wrong result).

That’s why your code manually checks before it happens.

Example: No overflow
x = 123


Reversed will go like:

reversed = 3
reversed = 32
reversed = 321


✅ 321 fits inside int range, so it’s fine.

Example: Overflow would happen
x = 1534236469


When you’re near the end, your reversed number might look like this:

reversed = 964632435
digit = 1


If you now do:

reversed * 10 + digit


that becomes:

964632435 * 10 + 1 = 9646324351


😱 That’s too large for int (greater than 2,147,483,647).
So Java would wrap it into a wrong negative number.

Hence, we check before multiplying by 10:

if (reversed > Integer.MAX_VALUE / 10) return 0;


That’s:

if (reversed > 214748364) → overflow next step


We also check if reversed == 214748364 and the next digit > 7,
because 214748364 * 10 + 8 = 2147483648 (overflow by 1).

⚖️ Signed vs Unsigned

In Java, all ints are signed — there is no unsigned int type.

That’s why you have two checks:

One for positive overflow → comparing with Integer.MAX_VALUE

One for negative overflow → comparing with Integer.MIN_VALUE

For negative overflow, similar logic:

if (reversed < Integer.MIN_VALUE / 10 ||
    (reversed == Integer.MIN_VALUE / 10 && digit < -8))


Here -8 comes from the last digit of -2147483648.

So you’re preventing:

-214748364 * 10 - 9 = -2147483649  ❌ (too small)
 */