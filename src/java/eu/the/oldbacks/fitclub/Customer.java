package eu.the.oldbacks.fitclub;

/**
 *
 * @author Stefano
 */
public class Customer {

    private final String name;
    private final String surname;
    private final boolean potential;
    private final String email;
    private final String phoneNumber;
    private final Subscription subscription;
    private final Subscription registration;
    
    private Customer(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.potential = builder.potential;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.subscription = builder.subscription;
        this.registration = builder.registration;
    }
    
    public class Builder {
        private final String name;
        private final String surname;
        private final Subscription subscription;
        private final boolean potential;
        private String email;
        private String phoneNumber;
        private Subscription registration;
        
        public Builder(String name, String surname, Subscription s) {
            if (name == null) throw new IllegalArgumentException("Parameter name cannot be NULL");
            if (surname == null) throw new IllegalArgumentException("Parameter surname cannot be NULL");
            if ( s == null ) throw new IllegalArgumentException("Parameter subscription cannot be NULL");
            this.name = name;
            this.surname = surname;
            this.subscription = s;
            this.potential = s.isTest();
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder phoneNumber(String phone) {
            this.phoneNumber = phone;
            return this;
        }
        public Builder registration(Subscription r) {
            this.registration = r;
            return this;
        }
        
        public Customer build() {
            return new Customer(this);
        }
    }
    
}
