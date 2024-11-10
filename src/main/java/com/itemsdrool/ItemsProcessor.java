package com.itemsdrool;

import java.util.ArrayList;
import java.util.List;

public class ItemsProcessor {
    public ItemsCombo getItems(ItemsCombo itemsCombo, Items item, ArrayList<ItemsDefn> itemsDefn) {
        List<ItemsStatement> itemsStatementList = itemsCombo.getItemsStatementInOrder();

        return itemsCombo;
    }

}
