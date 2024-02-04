package co.com.carvajal.transversal.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import lombok.Data;
import lombok.experimental.Delegate;

/**
 * ValidList
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Data
public class ValidList<E> implements List<E> {

    @Valid
    @Delegate
    private List<E> list = new ArrayList<>();

}
