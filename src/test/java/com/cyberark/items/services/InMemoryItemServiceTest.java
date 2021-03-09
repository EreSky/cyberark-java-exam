package com.cyberark.items.services;

import com.cyberark.items.entities.Item;
import com.cyberark.items.entities.ItemType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InMemoryItemServiceTest {
    @InjectMocks
    private InMemoryItemService inMemoryItemService;

    @Test
    public void whenNewServiceNoItems() {
        List<Item> itemList = inMemoryItemService.getItems();
        assertTrue(itemList.isEmpty());
    }

    @Test
    public void whenNoItemInMemoryThrow() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> inMemoryItemService.getItem(91));
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    public void whenNewItemCacheNotEmpty() {
        Item item = inMemoryItemService.addItem(new Item(1, ItemType.BANANA, 12, 15));
        List<Item> itemList = inMemoryItemService.getItems();
        assertFalse(itemList.isEmpty());
        assertNotNull(item);
    }

    @Test
    public void afterLoadDefaultItemList() throws Exception {
        inMemoryItemService.afterPropertiesSet();
        List<Item> itemList = inMemoryItemService.getItems();
        assertFalse(itemList.isEmpty());
        assertEquals(7, itemList.size());
    }
}
