package ke.co.rhino.bima.sec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountCredentials {
    private String username;
    private String password;
}
