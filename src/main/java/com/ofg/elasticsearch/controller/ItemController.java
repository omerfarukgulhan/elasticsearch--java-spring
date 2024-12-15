package com.ofg.elasticsearch.controller;

import com.ofg.elasticsearch.model.dto.SearchRequestDTO;
import com.ofg.elasticsearch.model.enitity.Item;
import com.ofg.elasticsearch.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public Item createIndex(@RequestBody Item item) {
        return itemService.createIndex(item);
    }

    @PostMapping("/init-index")
    public void addItemsFromJson() {
        itemService.addItemsFromJson();
    }

    @GetMapping("/findAll")
    public Iterable<Item> findAll() {
        return itemService.getItems();
    }

    @GetMapping("/allIndexes")
    public List<Item> getAllItemsFromAllIndexes() {
        return itemService.getAllItemsFromAllIndexes();
    }

    @GetMapping("/getAllDataFromIndex/{indexName}")
    public List<Item> getAllDataFromIndex(@PathVariable String indexName) {
        return itemService.getAllDataFromIndex(indexName);
    }

    @GetMapping("/search")
    public List<Item> searchItemsByFieldAndValue(@RequestBody SearchRequestDTO searchRequestDto) {
        return itemService.searchItemsByFieldAndValue(searchRequestDto);
    }

    @GetMapping("/search/{name}/{brand}")
    public List<Item> searchItemsByNameAndBrandWithQuery(@PathVariable String name, @PathVariable String brand) {
        return itemService.searchItemsByNameAndBrand(name, brand);
    }

    @GetMapping("/boolQuery")
    public List<Item> boolQuery(@RequestBody SearchRequestDTO searchRequestDto) {
        return itemService.boolQueryFieldAndValue(searchRequestDto);
    }

    @GetMapping("/autoSuggest/{name}")
    public Set<String> autoSuggestItemsByName(@PathVariable String name) {
        return itemService.findSuggestedItemNames(name);
    }

    @GetMapping("/suggestionsQuery/{name}")
    public List<String> autoSuggestItemsByNameWithQuery(@PathVariable String name) {
        return itemService.autoSuggestItemsByNameWithQuery(name);
    }
}