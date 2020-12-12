package StacksAndQs.impl;

import java.util.Deque;
import java.util.LinkedList;

public class CTCI_AnimalShelter {
	Deque<Integer> dog;
	Deque<Integer> cat;
	int totalAnimalCount = 0;

	public CTCI_AnimalShelter() {
		dog = new LinkedList<Integer>();
		cat = new LinkedList<Integer>();
	}

	void enQ(String animalType) {
		if (animalType.equalsIgnoreCase("DOG")) {
			dog.add(++totalAnimalCount);
		} else if (animalType.equalsIgnoreCase("CAT")) {
			cat.add(++totalAnimalCount);
		} else {
			// throw exception
		}
	}

	int dQAny() {
		if (dog.isEmpty() && cat.isEmpty()) {
			return -1;
		}

		if (dog.isEmpty()) {
			return cat.pollLast();
		}

		if (cat.isEmpty()) {
			return dog.pollLast();
		}

		if (dog.peekLast() < cat.peekLast()) {
			return dog.pollLast();
		} else if (dog.peekLast() > cat.peekLast()) {
			return cat.pollLast();
		}

		return -1;
	}

	int dqDog() {

		if (!dog.isEmpty()) {
			return dog.pollLast();
		}
		return -1;
	}

	int dqCat() {
		if (!cat.isEmpty()) {
			return cat.pollLast();
		}
		return -1;
	}

}
