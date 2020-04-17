package com.trickyjava.how.eventtracker.feign.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DrugDTO {

	@JsonProperty("product_code")
	private long productCode;
	
	@JsonProperty("display_name")
	private String displayName;
	
	@JsonProperty("manufacturer_id")
	private long manufacturerId;
	
	@JsonProperty("manufacturer_name")
	private String manufacturerName;
	
	@JsonProperty("availability_status")
	private String availabilityStatus;
	
	@JsonProperty("schedule")
	private String schedule;
	
	@JsonProperty("max_qty_in_order")
	private float maxQtyInOrder;
	
	@JsonProperty("mrp")
	private float mrp;
	
	@JsonProperty("selling_price")
	private float sellingPrice;
	
	@JsonProperty("discount_rate")
	private float discountRate;
	
	@JsonProperty("discount_pct")
	private float discountPct;
	
	@JsonProperty("discount")
	private float discount;
	
	@JsonProperty("in_stock")
	private int inStock;
	
	@JsonProperty("is_gen_subs_available")
	private int isGenSubsAvailable;
	
	@JsonProperty("formulation_type")
	private String formulationType;
	
	@JsonProperty("product_type")
	private String productType;
	
	@JsonProperty("release_type")
	private String releaseType;
	
	@JsonProperty("pack_label")
	private String packLabel;
	
	@JsonProperty("sold_qty_for_rank")
	private long soldQtyForRank;
	
	@JsonProperty("popularity")
	private float popularity;
	
	@JsonProperty("generic_id")
	private String genericId;
	
	@JsonProperty("generic")
	private String generic;
	
	@JsonProperty("generic_with_dosage_id")
	private long genericWithDosageId;
	
	@JsonProperty("generic_with_dosage")
	private String genericWithDosage;
	
	@JsonProperty("is_cold_storage")
	private int isColdStorage;

	@JsonProperty("rx_required")
	private int rxRequired;

	@JsonProperty("pack_size")
	private String packSize;

	@JsonProperty("category_ids")
	private List<Integer> categoryIds;

	@JsonProperty("image_url")
	private String imageUrl;
	
	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;
	
	@JsonProperty("categories")
	private List<String> categories;

	@JsonProperty("category_tree")
	private Map<String, Object> categoryTree;
	
	@JsonProperty("level1")
	private Map<String, Object> level1;
	
	@JsonProperty("objectID")
	private long objectID;
	
	@JsonProperty("_highlightResult")
	private Map<String,Object> highlightResult;

}
