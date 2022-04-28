package devoteam.robot.devoteam.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import devoteam.robot.devoteam.model.Field;

@Service
class ConfigFieldProvider implements FieldProvider {

    @Value("${field.width}")
    private int width;

    @Value("${field.height}")
    private int height;

    @Override
    public Field getField() {
        if (this.width < 1 || this.height < 1) {
            throw new IllegalStateException(
                "Field dimension must be positive"
            );
        }
        return new Field(this.width, this.height);
    }

}