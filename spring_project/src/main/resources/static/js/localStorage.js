// document.addEventListener("DOMContentLoaded", function () {
//     const checkboxes = document.querySelectorAll('.checkbox-group input[type="checkbox"]');
//     // localストレージにはキー・バリューで保存するため、"selectedCheckboxes"（キー）をわかりやすくするためstorageKey変数に代入する
//     const storageKey = "selectedCheckboxes";

//     // ローカルストレージからチェック状態を復元
//     const savedCheckboxes = JSON.parse(localStorage.getItem(storageKey)) || [];
//     checkboxes.forEach(checkbox => {
//         if (savedCheckboxes.includes(checkbox.id)) {
//             checkbox.checked = true;
//         }
//     });

//     // チェックボックスの変更をローカルストレージに保存
//     checkboxes.forEach(checkbox => {
//         checkbox.addEventListener("change", function () {
//             const checkedIds = Array.from(checkboxes)
//                 .filter(cb => cb.checked)
//                 .map(cb => cb.id);
//             localStorage.setItem(storageKey, JSON.stringify(checkedIds));
//         });
//     });
// });

// const storageKey = "selectedCheckboxes";
// const checkboxes = document.querySelectorAll('.checkbox-group input[type="checkbox"]');
// const checkboxGroup = document.querySelector(".checkbox-group");

// // ローカルストレージにチェック状態を保存
// function saveToLocalStorage() {
//     const checkedIds = Array.from(checkboxes)
//         .filter(cb => cb.checked)
//         .map(cb => cb.id);
//     localStorage.setItem(storageKey, JSON.stringify(checkedIds));
// }

// // ローカルストレージからチェック状態を復元
// function loadFromLocalStorage() {
//     const savedCheckboxes = JSON.parse(localStorage.getItem(storageKey)) || [];
//     checkboxes.forEach(checkbox => {
//         checkbox.checked = savedCheckboxes.includes(checkbox.id);
//     });
// }

// // チェックボックスの変更を監視（イベントデリゲーション）
// checkboxGroup.addEventListener("change", saveToLocalStorage);

// // 初回ロード時に状態を復元
// loadFromLocalStorage();

// <!-- <p class="password">おすすめ部位 </p>

//         <div class="checkbox-group">
// 			<div class="checkbox-item">
// 			  <label>
// 				<input type="checkbox" id="back" name="facility[]" value="back"> 背中
// 			  </label>
// 			</div>
		  
// 			<div class="checkbox-item">
// 			  <label>
// 				<input type="checkbox" id="chest" name="facility[]" value="chest"> 胸
// 			  </label>
// 			</div>
		  
// 			<div class="checkbox-item">
// 			  <label>
// 				<input type="checkbox" id="shoulder" name="facility[]" value="shoulder"> 肩
// 			  </label>
// 			</div>
		  
// 			<div class="checkbox-item">
// 			  <label>
// 				<input type="checkbox" id="arm" name="facility[]" value="arm"> 腕
// 			  </label>
// 			</div>
		  
// 			<div class="checkbox-item">
// 			  <label>
// 				<input type="checkbox" id="leg" name="facility[]" value="leg"> 脚（下半身）
// 			  </label>
// 			</div>
// 		  </div> -->