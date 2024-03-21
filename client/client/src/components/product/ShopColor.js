import PropTypes from "prop-types";
import { setActiveSort } from "../../helpers/product";

const availableColors = ["18 KT Yellow", "Yellow", "Red", "18 KT Rose", "18 KT Two Tone", "18 KT Three Tone", "14 KT Yellow", "14 KT White", "14 KT Rose", "14 KT Two Tone", "14 KT Three Tone", "Platinum 950 Platinum", "Platinum 950, 18 KT Two Tone"];

const ShopColor = ({ getSortParams }) => {
  return (
    <div className="sidebar-widget mt-50">
      <h4 className="pro-sidebar-title">Color </h4>
      <div className="sidebar-widget-list mt-20">
        {availableColors ? (
          <ul>
            <li>
              <div className="sidebar-widget-list-left">
                <button
                  onClick={(e) => {
                    getSortParams("color", "");
                    setActiveSort(e);
                  }}
                >
                  <span className="checkmark" /> All Colors{" "}
                </button>
              </div>
            </li>
            {availableColors.map((color, key) => {
              return (
                <li key={key}>
                  <div className="sidebar-widget-list-left">
                    <button
                      onClick={(e) => {
                        getSortParams("color", color);
                        setActiveSort(e);
                      }}
                    >
                      <span className="checkmark" /> {color}{" "}
                    </button>
                  </div>
                </li>
              );
            })}
          </ul>
        ) : (
          "No colors found"
        )}
      </div>
    </div>
  );
};

ShopColor.propTypes = {
  getSortParams: PropTypes.func,
};

export default ShopColor;
