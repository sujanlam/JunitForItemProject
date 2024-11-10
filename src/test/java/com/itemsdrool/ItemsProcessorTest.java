package com.itemsdrool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemsProcessorTest {
    private ItemsProcessor itemsProcessor;

    private ItemsCombo mockCombo;
    private Items mockItem;
    private ArrayList<ItemsDefn> itemsDefnList;

    @BeforeEach
    void setUp() {
        itemsProcessor = new ItemsProcessor();
        mockCombo = mock(ItemsCombo.class);
        mockItem = mock(Items.class);
        itemsDefnList = new ArrayList<>();
    }

    @Test
    void getItems() {
        List<ItemsStatement> itemsList = new ArrayList<>();
        ItemsStatement ist1 = new ItemsStatement();
        ist1.setId(1);
        ItemsStatement ist2 = new ItemsStatement();
        ist2.setId(2);
        itemsList.add(ist1);
        itemsList.add(ist2);

        when(mockCombo.getItemsStatementInOrder()).thenReturn(itemsList);

        ItemsCombo result = itemsProcessor.getItems(mockCombo, null, itemsDefnList);

        verify(mockCombo, times(1)).getItemsStatementInOrder();

        assertSame(mockCombo, result, "They should be same");
        assertNotEquals(0, result.getItemsStatementInOrder().size());
        assertEquals(2, result.getItemsStatementInOrder().size());
    }
}