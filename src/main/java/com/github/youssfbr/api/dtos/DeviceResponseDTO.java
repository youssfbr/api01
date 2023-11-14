package com.github.youssfbr.api.dtos;

import com.github.youssfbr.api.entities.Device;
import com.github.youssfbr.api.entities.enums.DeviceType;

public record DeviceResponseDTO(
        Long id,
        DeviceType deviceType,
        BrandResponseDTO brand,
        String model,
        String productId,
        String regTypeNo,
        String serviceTag,
        String expressServiceCode,
        String serialNumber,
        String fab,
        String voltage,
        String setup,
        String note
) {
    public DeviceResponseDTO(Device device) {
        this(
                device.getId() ,
                device.getDeviceType() ,
                new BrandResponseDTO(device.getBrand()) ,
                device.getModel() ,
                device.getProductId() ,
                device.getRegTypeNo() ,
                device.getServiceTag() ,
                device.getExpressServiceCode() ,
                device.getSerialNumber() ,
                device.getFab() ,
                device.getVoltage() ,
                device.getSetup() ,
                device.getNote()
        );
    }
}

