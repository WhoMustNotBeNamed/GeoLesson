package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Mountain;

import java.util.List;

public interface MountainService {
    // Метод для добавления горы
    void addMountain(Mountain mountain);

    // Метод для получения горы по имени
    Mountain getMountainByName(String name);

    // Метод для получения всех гор
    List<Mountain> getAllMountains();

    // Метод для обновления информации о горе
    void updateMountain(Mountain mountain);

    // Метод для удаления горы по имени
    void deleteMountainByName(String name);
}

