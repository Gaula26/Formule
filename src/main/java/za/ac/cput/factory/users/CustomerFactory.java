package za.ac.cput.factory.users;

import za.ac.cput.domain.users.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(
            String firstName,
            String lastName,
            String phoneNumber,
            String emailAddress,
            String password) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("First and last name are required");
        }

        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        if (!Helper.isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        if (!Helper.isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .setRole("ROLE_CUSTOMER")
                .build();
    }
}