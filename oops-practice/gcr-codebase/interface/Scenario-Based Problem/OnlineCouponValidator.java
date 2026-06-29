interface CouponValidator {

    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        if (code == null || code.isEmpty()) {
            return false;
        }
        return code.length() >= 5 && code.length() <= 12;
    }
}

class ShoppingCart implements CouponValidator {

    private String[] validCoupons = {"SAVE20", "FLAT50", "WELCOME10", "FESTIVE30", "NEWUSER"};

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            System.out.println("  [Length Check] FAILED - Code '" + code + "' has invalid length.");
            return false;
        }
        System.out.println("  [Length Check] PASSED - Code '" + code + "' has valid length (" + code.length() + " chars).");

        for (String validCode : validCoupons) {
            if (validCode.equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void applyCoupons(String[] customerCoupons) {
        System.out.println("\n========== SHOPPING CART - COUPON VALIDATION ==========\n");

        int validCount = 0;
        int invalidCount = 0;

        for (int i = 0; i < customerCoupons.length; i++) {
            String coupon = customerCoupons[i];
            System.out.println("Coupon #" + (i + 1) + ": \"" + coupon + "\"");

            boolean isValid = validateCoupon(coupon);

            if (isValid) {
                System.out.println("  >> STATUS: VALID - Discount applied!\n");
                validCount++;
            } else {
                System.out.println("  >> STATUS: INVALID - Coupon rejected.\n");
                invalidCount++;
            }
        }

        System.out.println("======================================================");
        System.out.println("SUMMARY: " + validCount + " valid | " + invalidCount + " invalid out of "
                + customerCoupons.length + " coupons.");
        System.out.println("======================================================\n");
    }
}

public class OnlineCouponValidator {
    public static void main(String[] args) {
        System.out.println("===== ONLINE COUPON VALIDATOR =====\n");

        String[] couponCodes = {
            "SAVE20",
            "FLAT50",
            "DISCOUNT99",
            "AB",
            "WELCOME10",
            "SUPERLONGCOUPONCODE123",
            "FESTIVE30",
            "",
            "NEWUSER",
            "FREEBIE"
        };

        ShoppingCart cart = new ShoppingCart();
        cart.applyCoupons(couponCodes);

        System.out.println("--- Direct Static Method Calls ---");
        System.out.println("isLengthValid(\"SAVE20\")   = " + CouponValidator.isLengthValid("SAVE20"));
        System.out.println("isLengthValid(\"AB\")       = " + CouponValidator.isLengthValid("AB"));
        System.out.println("isLengthValid(\"\")         = " + CouponValidator.isLengthValid(""));
        System.out.println("isLengthValid(null)       = " + CouponValidator.isLengthValid(null));
    }
}
