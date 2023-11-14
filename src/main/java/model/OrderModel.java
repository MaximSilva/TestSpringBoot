package model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue (generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String orderId;
    private double price;
    private int quantity;
    private String item;

}