package com.Task3;

import com.Task3.generated.Gun;

import java.util.List;

public interface MyGunXmlParser {
    List<Gun.Weapon> getWeaponListFromXml(String pathToXmlFile);
}
