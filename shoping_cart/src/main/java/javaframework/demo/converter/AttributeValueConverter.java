package javaframework.demo.converter;

import javaframework.demo.dto.AttributeValueDTO;
import javaframework.demo.entities.AttributeValueEntity;
import javaframework.demo.repository.AttributeRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributeValueConverter {

    @Autowired
    private AttributeRepos attributeRepos;

    public AttributeValueDTO toDto(AttributeValueEntity entity) {
        AttributeValueDTO dto = new AttributeValueDTO();
        dto.setValue(entity.getValue());
        dto.setAttributeId(entity.getAttributeEntity().getId());
        return dto;
    }

    public AttributeValueEntity toEntity(AttributeValueDTO dto) {
        AttributeValueEntity entity = new AttributeValueEntity();
        return getRoleEntity(entity,dto);
    }

    public AttributeValueEntity toEntity(AttributeValueEntity entity, AttributeValueDTO dto) {
        return getRoleEntity(entity,dto);
    }

    @NotNull
    private AttributeValueEntity getRoleEntity(AttributeValueEntity entity, AttributeValueDTO dto) {
        entity.setValue(dto.getValue());
        entity.setAttributeEntity(attributeRepos.findById(dto.getAttributeId()).get());
        return entity;
    }
}
