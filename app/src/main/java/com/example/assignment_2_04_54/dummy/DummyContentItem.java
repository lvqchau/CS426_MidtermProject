package com.example.assignment_2_04_54.dummy;

import com.example.assignment_2_04_54.R;
import com.example.assignment_2_04_54.dummy.content.Content;

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
public class DummyContentItem {

    public static final ArrayList<Content> CONTENT = new ArrayList<>();

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();

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



        String[] name = {
                "Item1",
                "Item6",
                "Item5",
                "Item4",
                "Item3",
                "Dress",
                "Jeans",
                "Jeans",
                "Jeans",
                "Shirt",
                "Dress",
                "Jeans",
                "Jeans",
                "Jeans",
                "Shirt",
                "Dress",
                "Jeans",
                "Jeans",
                "Jeans"
        };
        String[] describe = {
                "This is " + name[1] + "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio."
        };

        ArrayList<Integer> imageList = new ArrayList<>();
        for (int i=0; i<=COUNT; i++) {
            imageList.add(R.drawable.ic_google);
            imageList.add(R.drawable.ic_facebook);
            imageList.add(R.drawable.dress);
            imageList.add(R.drawable.ic_store);
            imageList.add(R.drawable.ic_camera);
        }


        for (int i = 0; i <= COUNT; i++) {
            CONTENT.add(new Content(name[i], describe[i], imageList.get(i)));
        }
        return new DummyItem(String.valueOf(position), CONTENT.get(position).getContent(), makeDetails(position), makeImages(position) );
    }



    private static String makeDetails(int position) {
        String[] describe = {
                "This is Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Modsdsrbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbcxcxcxi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Mordsdsbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morb4324i ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morc4324dcdbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morderetbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbidsds ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morb343242423i uldsdstrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Mor4234bi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ulxcxtrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbdsdsi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio.",
                "Morbi ultrices, mi nec varius aliquam, nibh neque commodo est, aliquet eleifend felis est a libero. Donec quis eros scelerisque, mollis purus eget, lobortis odio."
        };
        StringBuilder builder = new StringBuilder();
        builder.append(describe[position]);
        return builder.toString();
    }

    private static Integer makeImages(int position) {
        return CONTENT.get(position).getMyImageList();
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final int image;

        public DummyItem(String id, String content, String details, int image) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.image = image;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
