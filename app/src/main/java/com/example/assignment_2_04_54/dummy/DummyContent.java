package com.example.assignment_2_04_54.dummy;

import com.example.assignment_2_04_54.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 15;

    static {
        // Add some sample items.
        for (int i = 0; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



    private static DummyItem createDummyItem(int position) {

        String[] phone = {
                "0352916512",
                "0915345345",
                "0925352486",
                "0934718947",
                "9837482792",
                "4876427462",
                "4072409274",
                "1897428423",
                "0930114612",
                "0906732843",
                "0929384633",
                "0907238479",
                "0913463157",
                "7423874927",
                "0710237043",
                "0906838763",
                "0906274752"
        };

        String[] contact = {
                "Café de Nam",
                "Quynh Chau Shirt",
                "Hien Hien Dress",
                "Thanh Tran Phone",
                "Minhhuy Jeans",
                "PolkaSupplier",
                "BeigeSupplier",
                "Fabric",
                "Leather",
                "Accessories",
                "Shoes laces",
                "Hair dyed",
                "Dog Food",
                "Chau Tran",
                "Notebook",
                "Cutestuff"
        };


        ArrayList<Integer> imageList = new ArrayList<>();
        for (int i=0; i<=COUNT; i++) {
            imageList.add(R.drawable.ic_user);
        }


        return new DummyItem(String.valueOf(position), contact[position], phone[position], imageList.get(position));
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String contactName;
        public final String phoneNumber;
        public final int image;

        public DummyItem(String id, String contactName, String phoneNumber, int image) {
            this.id = id;
            this.contactName = contactName;
            this.phoneNumber = phoneNumber;
            this.image = image;
        }

        @Override
        public String toString() {
            return contactName;
        }
    }
}
