import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import { setActiveSort } from "../../helpers/product";
import axios from "axios";

const ShopCategories = ({ getSortParams }) => {
  console.log(getSortParams)
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("");

  const fetchCategoriesFromApi = async () => {
    try {
      const response = await axios.get("http://localhost:5000/api/v1/product/cat");
      setCategories(response.data); // Assuming the categories are available in response.data
      console.log(response.data)
    } catch (error) {
      console.error("Error fetching categories:", error);
      setCategories([]);
    }
  };

  useEffect(() => {
    fetchCategoriesFromApi();
  }, []);

  const handleCategoryClick = (category) => {
    setSelectedCategory(category);

    // Trigger the sort and set active sort
    getSortParams("category", category);
    setActiveSort(category);
  };

  return (
    <div className="sidebar-widget">
      <h4 className="pro-sidebar-title">Categories </h4>
      <div className="sidebar-widget-list mt-30">
        {categories.length > 0 ? (
          <ul>
            <li>
              <div className="sidebar-widget-list-left">
                <button onClick={() => handleCategoryClick("")}>
                  <span className="checkmark" /> All Categories
                </button>
              </div>
            </li>
            {categories.map((category) => (
              <li key={category._id}>
                <div className="sidebar-widget-list-left">
                  <button onClick={() => handleCategoryClick(category.categoryName)}>
                    <span className="checkmark" /> {category.categoryName}
                  </button>
                </div>
              </li>
            ))}
          </ul>
        ) : (
          "No categories found"
        )}
      </div>
    </div>
  );
};

ShopCategories.propTypes = {
  getSortParams: PropTypes.func,
};

export default ShopCategories;
