package com.bessonov;

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int size = 0;

    public void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
        System.out.println("Список с нашими резюме полностью отчищен");
    }

    public void save(Resume resume) {
        if (size < storage.length) {
            storage[size] = resume;
            System.out.println("Резюме добавлено");
            size++;
        } else {
            System.out.println("Error");
        }
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i] == resume) {
                System.out.println("Данное резюме есть в нашем списке.");
            } else {
                System.out.println("Error");
            }
        }
    }

    public String get(String uuid) {
        String result = "Error";
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                result = resume.uuid;
            }
        }
        return result;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size] = null;
                size--;
                System.out.println("Вы удалили данное резюме.");
            } else {
                System.out.println("Error");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
