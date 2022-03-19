
/**
 * 
 * @param itemName - String
 * @param itemId - String
 * @param itemValue - String
 * @returns if itemValue == null || '' || undefined => return false
 *  else: return true
 */
function isRequired(itemName, itemId, itemValue) {
	if (!itemValue) {
		alert(VALID_REQUIRED_MSG.replace('param1', itemName));
		setItemError(itemId);
		return false;
	}
	return true;
}

/**
 * @param itemName - String
 * @param value - String
 * @param maxLength - number
 * @param required - boolean
 * @param decimalPart - boolean
 * @returns boolean
 *  required == true, itemValue == '' => return false
 *  itemValue == '123.4', max-length == 6 => return false
 *  itemValue == '123.4', max-length == 5 => return true
 *  itemValue == '12345', max-length == 5 => return true
 *  itemValue == '123.4' decimalPart == false => return false
 *  itemValue == '123.4' decimalPart == true => return true
 *  itemValue == '1.1abc' => return false
 *  itemValue == '1.2.3' => return false
 */
function checkNumber(itemName, itemId, itemValue, maxLength, required, decimalPart) {
	if (required && !itemValue) {
		alert(VALID_REQUIRED_MSG.replace('param1', itemName));
		setItemError(itemId);
		return false;
	}
	
	if (!required && !itemValue) {
		return true;
	}
	
	if (itemValue.length > maxLength) {
		alert(VALID_MAXLENGTH_MSG.replace('param1', itemName).replace('param2', maxLength));
		setItemError(itemId);
		return false;
	}
	
	if (!decimalPart && itemValue.indexOf('.') != -1) {
		alert(VALID_DECIMAL_MSG.replace('param1', itemName));
		setItemError(itemId);
		return false;
	}
	
	if (!$.isNumeric(itemValue)) {
		alert(VALID_NUMERIC_MSG.replace('param1', itemName));
		setItemError(itemId);
		return false;
	}
	
	return true;
}

/**
 * 
 * @param itemName
 * @param itemId
 * @param itemValue
 * @param format
 * @param required
 * @returns
 */
function checkDateTime(itemName, itemId, itemValue, format, required) {
	if (required && !itemValue) {
		alert(VALID_REQUIRED_MSG.replace('param1', itemName));
		setItemError(itemId);
		return false;
	}
	
	if (!required && !itemValue) {
		return true;
	}
	
	var lengthFormat = format.length;
	if (itemValue.length != lengthFormat) {
		alert(VALID_MAXLENGTH_MSG.replace('param1', itemName).replace('param2', lengthFormat));
		setItemError(itemId);
		return false;
	}
	
	var regEx = '';
	
	if (format == 'dd/mm/yyyy') {
		regEx = /^\d{2}\/\d{2}\/\d{4}$/;
	}
	
	if(!itemValue.match(regEx)) {
		alert(VALID_DATE_MSG.replace('param1', itemName).replace('param2', format));
		setItemError(itemId);
		return false;
	}
//	var d = new Date(itemValue);
	var d = new Date(itemValue.replace( /(\d{2})\/(\d{2})\/(\d{4})/, "$2/$1/$3"))
	
	var dNum = d.getTime();
	if (!dNum && dNum !== 0) {
		alert(VALID_DATE_MSG.replace('param1', itemName).replace('param2', format));
		setItemError(itemId);
		return false;
	}
	return true;
}

/**
 * 
 * @param itemNameFrom  - String
 * @param itemIdFrom - String
 * @param itemValueFrom - String
 * @param itemNameTo - String
 * @param itemIdTo - String
 * @param itemValueTo - String
 * @returns if itemValueFrom > itemValueTo => return false
 *  else: return true
 */
function checkFromTo(itemNameFrom, itemIdFrom, itemValueFrom, itemNameTo, itemIdTo, itemValueTo) {
	if (itemValueFrom > itemValueTo) {
		alert(VALID_FROM_TO_MSG.replace('param1', itemNameFrom).replace('param2', itemNameTo));
		setItemError(itemIdTo);
		setItemError(itemIdFrom);
		return false;
	}
	
	return true;
}

function setItemError(itemId) {
	$('#' + itemId).focus();
	$('#' + itemId).addClass('error');
}

function clearItemError(itemId) {
	
	if ($('#' + itemId).hasClass('error')) {
		$('#' + itemId).removeClass('error');
		
	}
}