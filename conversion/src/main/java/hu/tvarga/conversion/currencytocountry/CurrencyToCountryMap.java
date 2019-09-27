package hu.tvarga.conversion.currencytocountry;

/**
 * Taken from https://gist.github.com/HarishChaudhari/4680482#gistcomment-2925626 for real real
 * production I'd probably look harder for a library to do this mapping, or look for a service to
 * provide this mapping, or expect the design / BA team to provide data for this
 */
class CurrencyToCountryMap {

	private CurrencyToCountryMap() {
		//  hiding constructor of static helper class
	}

	static final String JSON = "[\n" +
			"    {\"Country\": \"New Zealand\", \"CountryCode\": \"NZ\", \"Currency\": \"New Zealand Dollars\", \"Code\": \"NZD\"},\n" +
			"    {\"Country\": \"Cook Islands\", \"CountryCode\": \"CK\", \"Currency\": \"New Zealand Dollars\", \"Code\": \"NZD\"},\n" +
			"    {\"Country\": \"Niue\", \"CountryCode\": \"NU\", \"Currency\": \"New Zealand Dollars\", \"Code\": \"NZD\"},\n" +
			"    {\"Country\": \"Pitcairn\", \"CountryCode\": \"PN\", \"Currency\": \"New Zealand Dollars\", \"Code\": \"NZD\"},\n" +
			"    {\"Country\": \"Tokelau\", \"CountryCode\": \"TK\", \"Currency\": \"New Zealand Dollars\", \"Code\": \"NZD\"},\n" +
			"    {\"Country\": \"Australian\", \"CountryCode\": \"AU\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Christmas Island\", \"CountryCode\": \"CX\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Cocos (Keeling) Islands\", \"CountryCode\": \"CC\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Heard and Mc Donald Islands\", \"CountryCode\": \"HM\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Kiribati\", \"CountryCode\": \"KI\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Nauru\", \"CountryCode\": \"NR\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Norfolk Island\", \"CountryCode\": \"NF\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"Tuvalu\", \"CountryCode\": \"TV\", \"Currency\": \"Australian Dollars\", \"Code\": \"AUD\"},\n" +
			"    {\"Country\": \"American Samoa\", \"CountryCode\": \"AS\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Andorra\", \"CountryCode\": \"AD\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Austria\", \"CountryCode\": \"AT\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Belgium\", \"CountryCode\": \"BE\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Finland\", \"CountryCode\": \"FI\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"France\", \"CountryCode\": \"FR\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"French Guiana\", \"CountryCode\": \"GF\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"French Southern Territories\", \"CountryCode\": \"TF\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Germany\", \"CountryCode\": \"DE\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Greece\", \"CountryCode\": \"GR\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Guadeloupe\", \"CountryCode\": \"GP\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Ireland\", \"CountryCode\": \"IE\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Italy\", \"CountryCode\": \"IT\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Luxembourg\", \"CountryCode\": \"LU\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Martinique\", \"CountryCode\": \"MQ\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Mayotte\", \"CountryCode\": \"YT\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Monaco\", \"CountryCode\": \"MC\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Netherlands\", \"CountryCode\": \"NL\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Portugal\", \"CountryCode\": \"PT\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Reunion\", \"CountryCode\": \"RE\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Samoa\", \"CountryCode\": \"WS\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"San Marino\", \"CountryCode\": \"SM\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Slovenia\", \"CountryCode\": \"SI\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Spain\", \"CountryCode\": \"ES\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Vatican City State (Holy See)\", \"CountryCode\": \"VA\", \"Currency\": \"Euros\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"South Georgia and the South Sandwich Islands\", \"CountryCode\": \"GS\", \"Currency\": \"Sterling\", \"Code\": \"GBP\"},\n" +
			"    {\"Country\": \"United Kingdom\", \"CountryCode\": \"GB\", \"Currency\": \"Sterling\", \"Code\": \"GBP\"},\n" +
			"    {\"Country\": \"Jersey\", \"CountryCode\": \"JE\", \"Currency\": \"Sterling\", \"Code\": \"GBP\"},\n" +
			"    {\"Country\": \"British Indian Ocean Territory\", \"CountryCode\": \"IO\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Guam\", \"CountryCode\": \"GU\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Marshall Islands\", \"CountryCode\": \"MH\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Micronesia Federated States of\", \"CountryCode\": \"FM\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Northern Mariana Islands\", \"CountryCode\": \"MP\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Palau\", \"CountryCode\": \"PW\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Puerto Rico\", \"CountryCode\": \"PR\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Turks and Caicos Islands\", \"CountryCode\": \"TC\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"United States\", \"CountryCode\": \"US\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"United States Minor Outlying Islands\", \"CountryCode\": \"UM\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Virgin Islands (British)\", \"CountryCode\": \"VG\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Virgin Islands (US)\", \"CountryCode\": \"VI\", \"Currency\": \"USD\", \"Code\": \"USD\"},\n" +
			"    {\"Country\": \"Hong Kong\", \"CountryCode\": \"HK\", \"Currency\": \"HKD\", \"Code\": \"HKD\"},\n" +
			"    {\"Country\": \"Canada\", \"CountryCode\": \"CA\", \"Currency\": \"Canadian Dollar\", \"Code\": \"CAD\"},\n" +
			"    {\"Country\": \"Japan\", \"CountryCode\": \"JP\", \"Currency\": \"Japanese Yen\", \"Code\": \"JPY\"},\n" +
			"    {\"Country\": \"Afghanistan\", \"CountryCode\": \"AF\", \"Currency\": \"Afghani\", \"Code\": \"AFN\"},\n" +
			"    {\"Country\": \"Albania\", \"CountryCode\": \"AL\", \"Currency\": \"Lek\", \"Code\": \"ALL\"},\n" +
			"    {\"Country\": \"Algeria\", \"CountryCode\": \"DZ\", \"Currency\": \"Algerian Dinar\", \"Code\": \"DZD\"},\n" +
			"    {\"Country\": \"Anguilla\", \"CountryCode\": \"AI\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Antigua and Barbuda\", \"CountryCode\": \"AG\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Dominica\", \"CountryCode\": \"DM\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Grenada\", \"CountryCode\": \"GD\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Montserrat\", \"CountryCode\": \"MS\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Saint Kitts\", \"CountryCode\": \"KN\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Saint Lucia\", \"CountryCode\": \"LC\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Saint Vincent Grenadines\", \"CountryCode\": \"VC\", \"Currency\": \"East Caribbean Dollar\", \"Code\": \"XCD\"},\n" +
			"    {\"Country\": \"Argentina\", \"CountryCode\": \"AR\", \"Currency\": \"Peso\", \"Code\": \"ARS\"},\n" +
			"    {\"Country\": \"Armenia\", \"CountryCode\": \"AM\", \"Currency\": \"Dram\", \"Code\": \"AMD\"},\n" +
			"    {\"Country\": \"Aruba\", \"CountryCode\": \"AW\", \"Currency\": \"Netherlands Antilles Guilder\", \"Code\": \"ANG\"},\n" +
			"    {\"Country\": \"Netherlands Antilles\", \"CountryCode\": \"AN\", \"Currency\": \"Netherlands Antilles Guilder\", \"Code\": \"ANG\"},\n" +
			"    {\"Country\": \"Azerbaijan\", \"CountryCode\": \"AZ\", \"Currency\": \"Manat\", \"Code\": \"AZN\"},\n" +
			"    {\"Country\": \"Bahamas\", \"CountryCode\": \"BS\", \"Currency\": \"Bahamian Dollar\", \"Code\": \"BSD\"},\n" +
			"    {\"Country\": \"Bahrain\", \"CountryCode\": \"BH\", \"Currency\": \"Bahraini Dinar\", \"Code\": \"BHD\"},\n" +
			"    {\"Country\": \"Bangladesh\", \"CountryCode\": \"BD\", \"Currency\": \"Taka\", \"Code\": \"BDT\"},\n" +
			"    {\"Country\": \"Barbados\", \"CountryCode\": \"BB\", \"Currency\": \"Barbadian Dollar\", \"Code\": \"BBD\"},\n" +
			"    {\"Country\": \"Belarus\", \"CountryCode\": \"BY\", \"Currency\": \"Belarus Ruble\", \"Code\": \"BYR\"},\n" +
			"    {\"Country\": \"Belize\", \"CountryCode\": \"BZ\", \"Currency\": \"Belizean Dollar\", \"Code\": \"BZD\"},\n" +
			"    {\"Country\": \"Benin\", \"CountryCode\": \"BJ\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Burkina Faso\", \"CountryCode\": \"BF\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Guinea-Bissau\", \"CountryCode\": \"GW\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Ivory Coast\", \"CountryCode\": \"CI\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Mali\", \"CountryCode\": \"ML\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Niger\", \"CountryCode\": \"NE\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Senegal\", \"CountryCode\": \"SN\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Togo\", \"CountryCode\": \"TG\", \"Currency\": \"CFA Franc BCEAO\", \"Code\": \"XOF\"},\n" +
			"    {\"Country\": \"Bermuda\", \"CountryCode\": \"BM\", \"Currency\": \"Bermudian Dollar\", \"Code\": \"BMD\"},\n" +
			"    {\"Country\": \"Bhutan\", \"CountryCode\": \"BT\", \"Currency\": \"Indian Rupee\", \"Code\": \"INR\"},\n" +
			"    {\"Country\": \"India\", \"CountryCode\": \"IN\", \"Currency\": \"Indian Rupee\", \"Code\": \"INR\"},\n" +
			"    {\"Country\": \"Bolivia\", \"CountryCode\": \"BO\", \"Currency\": \"Boliviano\", \"Code\": \"BOB\"},\n" +
			"    {\"Country\": \"Botswana\", \"CountryCode\": \"BW\", \"Currency\": \"Pula\", \"Code\": \"BWP\"},\n" +
			"    {\"Country\": \"Bouvet Island\", \"CountryCode\": \"BV\", \"Currency\": \"Norwegian Krone\", \"Code\": \"NOK\"},\n" +
			"    {\"Country\": \"Norway\", \"CountryCode\": \"NO\", \"Currency\": \"Norwegian Krone\", \"Code\": \"NOK\"},\n" +
			"    {\"Country\": \"Svalbard and Jan Mayen Islands\", \"CountryCode\": \"SJ\", \"Currency\": \"Norwegian Krone\", \"Code\": \"NOK\"},\n" +
			"    {\"Country\": \"Brazil\", \"CountryCode\": \"BR\", \"Currency\": \"Brazil\", \"Code\": \"BRL\"},\n" +
			"    {\"Country\": \"Brunei Darussalam\", \"CountryCode\": \"BN\", \"Currency\": \"Bruneian Dollar\", \"Code\": \"BND\"},\n" +
			"    {\"Country\": \"Bulgaria\", \"CountryCode\": \"BG\", \"Currency\": \"Lev\", \"Code\": \"BGN\"},\n" +
			"    {\"Country\": \"Burundi\", \"CountryCode\": \"BI\", \"Currency\": \"Burundi Franc\", \"Code\": \"BIF\"},\n" +
			"    {\"Country\": \"Cambodia\", \"CountryCode\": \"KH\", \"Currency\": \"Riel\", \"Code\": \"KHR\"},\n" +
			"    {\"Country\": \"Cameroon\", \"CountryCode\": \"CM\", \"Currency\": \"CFA Franc BEAC\", \"Code\": \"XAF\"},\n" +
			"    {\"Country\": \"Central African Republic\", \"CountryCode\": \"CF\", \"Currency\": \"CFA Franc BEAC\", \"Code\": \"XAF\"},\n" +
			"    {\"Country\": \"Chad\", \"CountryCode\": \"TD\", \"Currency\": \"CFA Franc BEAC\", \"Code\": \"XAF\"},\n" +
			"    {\"Country\": \"Congo Republic of the Democratic\", \"CountryCode\": \"CG\", \"Currency\": \"CFA Franc BEAC\", \"Code\": \"XAF\"},\n" +
			"    {\"Country\": \"Equatorial Guinea\", \"CountryCode\": \"GQ\", \"Currency\": \"CFA Franc BEAC\", \"Code\": \"XAF\"},\n" +
			"    {\"Country\": \"Gabon\", \"CountryCode\": \"GA\", \"Currency\": \"CFA Franc BEAC\", \"Code\": \"XAF\"},\n" +
			"    {\"Country\": \"Cape Verde\", \"CountryCode\": \"CV\", \"Currency\": \"Escudo\", \"Code\": \"CVE\"},\n" +
			"    {\"Country\": \"Cayman Islands\", \"CountryCode\": \"KY\", \"Currency\": \"Caymanian Dollar\", \"Code\": \"KYD\"},\n" +
			"    {\"Country\": \"Chile\", \"CountryCode\": \"CL\", \"Currency\": \"Chilean Peso\", \"Code\": \"CLP\"},\n" +
			"    {\"Country\": \"China\", \"CountryCode\": \"CN\", \"Currency\": \"Yuan Renminbi\", \"Code\": \"CNY\"},\n" +
			"    {\"Country\": \"Colombia\", \"CountryCode\": \"CO\", \"Currency\": \"Peso\", \"Code\": \"COP\"},\n" +
			"    {\"Country\": \"Comoros\", \"CountryCode\": \"KM\", \"Currency\": \"Comoran Franc\", \"Code\": \"KMF\"},\n" +
			"    {\"Country\": \"Congo-Brazzaville\", \"CountryCode\": \"CD\", \"Currency\": \"Congolese Frank\", \"Code\": \"CDF\"},\n" +
			"    {\"Country\": \"Costa Rica\", \"CountryCode\": \"CR\", \"Currency\": \"Costa Rican Colon\", \"Code\": \"CRC\"},\n" +
			"    {\"Country\": \"Croatia (Hrvatska)\", \"CountryCode\": \"HR\", \"Currency\": \"Croatian Dinar\", \"Code\": \"HRK\"},\n" +
			"    {\"Country\": \"Cuba\", \"CountryCode\": \"CU\", \"Currency\": \"Cuban Peso\", \"Code\": \"CUP\"},\n" +
			"    {\"Country\": \"Cyprus\", \"CountryCode\": \"CY\", \"Currency\": \"Cypriot Pound\", \"Code\": \"CYP\"},\n" +
			"    {\"Country\": \"Czech Republic\", \"CountryCode\": \"CZ\", \"Currency\": \"Koruna\", \"Code\": \"CZK\"},\n" +
			"    {\"Country\": \"Denmark\", \"CountryCode\": \"DK\", \"Currency\": \"Danish Krone\", \"Code\": \"DKK\"},\n" +
			"    {\"Country\": \"Faroe Islands\", \"CountryCode\": \"FO\", \"Currency\": \"Danish Krone\", \"Code\": \"DKK\"},\n" +
			"    {\"Country\": \"Greenland\", \"CountryCode\": \"GL\", \"Currency\": \"Danish Krone\", \"Code\": \"DKK\"},\n" +
			"    {\"Country\": \"Djibouti\", \"CountryCode\": \"DJ\", \"Currency\": \"Djiboutian Franc\", \"Code\": \"DJF\"},\n" +
			"    {\"Country\": \"Dominican Republic\", \"CountryCode\": \"DO\", \"Currency\": \"Dominican Peso\", \"Code\": \"DOP\"},\n" +
			"    {\"Country\": \"East Timor\", \"CountryCode\": \"TP\", \"Currency\": \"Indonesian Rupiah\", \"Code\": \"IDR\"},\n" +
			"    {\"Country\": \"Indonesia\", \"CountryCode\": \"ID\", \"Currency\": \"Indonesian Rupiah\", \"Code\": \"IDR\"},\n" +
			"    {\"Country\": \"Ecuador\", \"CountryCode\": \"EC\", \"Currency\": \"Sucre\", \"Code\": \"ECS\"},\n" +
			"    {\"Country\": \"Egypt\", \"CountryCode\": \"EG\", \"Currency\": \"Egyptian Pound\", \"Code\": \"EGP\"},\n" +
			"    {\"Country\": \"El Salvador\", \"CountryCode\": \"SV\", \"Currency\": \"Salvadoran Colon\", \"Code\": \"SVC\"},\n" +
			"    {\"Country\": \"Eritrea\", \"CountryCode\": \"ER\", \"Currency\": \"Ethiopian Birr\", \"Code\": \"ETB\"},\n" +
			"    {\"Country\": \"Ethiopia\", \"CountryCode\": \"ET\", \"Currency\": \"Ethiopian Birr\", \"Code\": \"ETB\"},\n" +
			"    {\"Country\": \"Estonia\", \"CountryCode\": \"EE\", \"Currency\": \"Estonian Kroon\", \"Code\": \"EEK\"},\n" +
			"    {\"Country\": \"Falkland Islands (Malvinas)\", \"CountryCode\": \"FK\", \"Currency\": \"Falkland Pound\", \"Code\": \"FKP\"},\n" +
			"    {\"Country\": \"Fiji\", \"CountryCode\": \"FJ\", \"Currency\": \"Fijian Dollar\", \"Code\": \"FJD\"},\n" +
			"    {\"Country\": \"French Polynesia\", \"CountryCode\": \"PF\", \"Currency\": \"CFP Franc\", \"Code\": \"XPF\"},\n" +
			"    {\"Country\": \"New Caledonia\", \"CountryCode\": \"NC\", \"Currency\": \"CFP Franc\", \"Code\": \"XPF\"},\n" +
			"    {\"Country\": \"Wallis and Futuna Islands\", \"CountryCode\": \"WF\", \"Currency\": \"CFP Franc\", \"Code\": \"XPF\"},\n" +
			"    {\"Country\": \"Gambia\", \"CountryCode\": \"GM\", \"Currency\": \"Dalasi\", \"Code\": \"GMD\"},\n" +
			"    {\"Country\": \"Georgia\", \"CountryCode\": \"GE\", \"Currency\": \"Lari\", \"Code\": \"GEL\"},\n" +
			"    {\"Country\": \"Gibraltar\", \"CountryCode\": \"GI\", \"Currency\": \"Gibraltar Pound\", \"Code\": \"GIP\"},\n" +
			"    {\"Country\": \"Guatemala\", \"CountryCode\": \"GT\", \"Currency\": \"Quetzal\", \"Code\": \"GTQ\"},\n" +
			"    {\"Country\": \"Guinea\", \"CountryCode\": \"GN\", \"Currency\": \"Guinean Franc\", \"Code\": \"GNF\"},\n" +
			"    {\"Country\": \"Guyana\", \"CountryCode\": \"GY\", \"Currency\": \"Guyanaese Dollar\", \"Code\": \"GYD\"},\n" +
			"    {\"Country\": \"Haiti\", \"CountryCode\": \"HT\", \"Currency\": \"Gourde\", \"Code\": \"HTG\"},\n" +
			"    {\"Country\": \"Honduras\", \"CountryCode\": \"HN\", \"Currency\": \"Lempira\", \"Code\": \"HNL\"},\n" +
			"    {\"Country\": \"Hungary\", \"CountryCode\": \"HU\", \"Currency\": \"Forint\", \"Code\": \"HUF\"},\n" +
			"    {\"Country\": \"Iceland\", \"CountryCode\": \"IS\", \"Currency\": \"Icelandic Krona\", \"Code\": \"ISK\"},\n" +
			"    {\"Country\": \"Iran (Islamic Republic of)\", \"CountryCode\": \"IR\", \"Currency\": \"Iranian Rial\", \"Code\": \"IRR\"},\n" +
			"    {\"Country\": \"Iraq\", \"CountryCode\": \"IQ\", \"Currency\": \"Iraqi Dinar\", \"Code\": \"IQD\"},\n" +
			"    {\"Country\": \"Israel\", \"CountryCode\": \"IL\", \"Currency\": \"Shekel\", \"Code\": \"ILS\"},\n" +
			"    {\"Country\": \"Jamaica\", \"CountryCode\": \"JM\", \"Currency\": \"Jamaican Dollar\", \"Code\": \"JMD\"},\n" +
			"    {\"Country\": \"Jordan\", \"CountryCode\": \"JO\", \"Currency\": \"Jordanian Dinar\", \"Code\": \"JOD\"},\n" +
			"    {\"Country\": \"Kazakhstan\", \"CountryCode\": \"KZ\", \"Currency\": \"Tenge\", \"Code\": \"KZT\"},\n" +
			"    {\"Country\": \"Kenya\", \"CountryCode\": \"KE\", \"Currency\": \"Kenyan Shilling\", \"Code\": \"KES\"},\n" +
			"    {\"Country\": \"Korea North\", \"CountryCode\": \"KP\", \"Currency\": \"Won\", \"Code\": \"KPW\"},\n" +
			"    {\"Country\": \"Korea South\", \"CountryCode\": \"KR\", \"Currency\": \"Won\", \"Code\": \"KRW\"},\n" +
			"    {\"Country\": \"Kuwait\", \"CountryCode\": \"KW\", \"Currency\": \"Kuwaiti Dinar\", \"Code\": \"KWD\"},\n" +
			"    {\"Country\": \"Kyrgyzstan\", \"CountryCode\": \"KG\", \"Currency\": \"Som\", \"Code\": \"KGS\"},\n" +
			"    {\"Country\": \"Lao PeopleÕs Democratic Republic\", \"CountryCode\": \"LA\", \"Currency\": \"Kip\", \"Code\": \"LAK\"},\n" +
			"    {\"Country\": \"Latvia\", \"CountryCode\": \"LV\", \"Currency\": \"Lat\", \"Code\": \"LVL\"},\n" +
			"    {\"Country\": \"Lebanon\", \"CountryCode\": \"LB\", \"Currency\": \"Lebanese Pound\", \"Code\": \"LBP\"},\n" +
			"    {\"Country\": \"Lesotho\", \"CountryCode\": \"LS\", \"Currency\": \"Loti\", \"Code\": \"LSL\"},\n" +
			"    {\"Country\": \"Liberia\", \"CountryCode\": \"LR\", \"Currency\": \"Liberian Dollar\", \"Code\": \"LRD\"},\n" +
			"    {\"Country\": \"Libyan Arab Jamahiriya\", \"CountryCode\": \"LY\", \"Currency\": \"Libyan Dinar\", \"Code\": \"LYD\"},\n" +
			"    {\"Country\": \"Liechtenstein\", \"CountryCode\": \"LI\", \"Currency\": \"Swiss Franc\", \"Code\": \"CHF\"},\n" +
			"    {\"Country\": \"Switzerland\", \"CountryCode\": \"CH\", \"Currency\": \"Swiss Franc\", \"Code\": \"CHF\"},\n" +
			"    {\"Country\": \"Lithuania\", \"CountryCode\": \"LT\", \"Currency\": \"Lita\", \"Code\": \"LTL\"},\n" +
			"    {\"Country\": \"Macau\", \"CountryCode\": \"MO\", \"Currency\": \"Pataca\", \"Code\": \"MOP\"},\n" +
			"    {\"Country\": \"Macedonia\", \"CountryCode\": \"MK\", \"Currency\": \"Denar\", \"Code\": \"MKD\"},\n" +
			"    {\"Country\": \"Madagascar\", \"CountryCode\": \"MG\", \"Currency\": \"Malagasy Franc\", \"Code\": \"MGA\"},\n" +
			"    {\"Country\": \"Malawi\", \"CountryCode\": \"MW\", \"Currency\": \"Malawian Kwacha\", \"Code\": \"MWK\"},\n" +
			"    {\"Country\": \"Malaysia\", \"CountryCode\": \"MY\", \"Currency\": \"Ringgit\", \"Code\": \"MYR\"},\n" +
			"    {\"Country\": \"Maldives\", \"CountryCode\": \"MV\", \"Currency\": \"Rufiyaa\", \"Code\": \"MVR\"},\n" +
			"    {\"Country\": \"Malta\", \"CountryCode\": \"MT\", \"Currency\": \"Maltese Lira\", \"Code\": \"MTL\"},\n" +
			"    {\"Country\": \"Mauritania\", \"CountryCode\": \"MR\", \"Currency\": \"Ouguiya\", \"Code\": \"MRO\"},\n" +
			"    {\"Country\": \"Mauritius\", \"CountryCode\": \"MU\", \"Currency\": \"Mauritian Rupee\", \"Code\": \"MUR\"},\n" +
			"    {\"Country\": \"Mexico\", \"CountryCode\": \"MX\", \"Currency\": \"Peso\", \"Code\": \"MXN\"},\n" +
			"    {\"Country\": \"Moldova Republic of\", \"CountryCode\": \"MD\", \"Currency\": \"Leu\", \"Code\": \"MDL\"},\n" +
			"    {\"Country\": \"Mongolia\", \"CountryCode\": \"MN\", \"Currency\": \"Tugrik\", \"Code\": \"MNT\"},\n" +
			"    {\"Country\": \"Morocco\", \"CountryCode\": \"MA\", \"Currency\": \"Dirham\", \"Code\": \"MAD\"},\n" +
			"    {\"Country\": \"Western Sahara\", \"CountryCode\": \"EH\", \"Currency\": \"Dirham\", \"Code\": \"MAD\"},\n" +
			"    {\"Country\": \"Mozambique\", \"CountryCode\": \"MZ\", \"Currency\": \"Metical\", \"Code\": \"MZN\"},\n" +
			"    {\"Country\": \"Myanmar\", \"CountryCode\": \"MM\", \"Currency\": \"Kyat\", \"Code\": \"MMK\"},\n" +
			"    {\"Country\": \"Namibia\", \"CountryCode\": \"NA\", \"Currency\": \"Dollar\", \"Code\": \"NAD\"},\n" +
			"    {\"Country\": \"Nepal\", \"CountryCode\": \"NP\", \"Currency\": \"Nepalese Rupee\", \"Code\": \"NPR\"},\n" +
			"    {\"Country\": \"Nicaragua\", \"CountryCode\": \"NI\", \"Currency\": \"Cordoba Oro\", \"Code\": \"NIO\"},\n" +
			"    {\"Country\": \"Nigeria\", \"CountryCode\": \"NG\", \"Currency\": \"Naira\", \"Code\": \"NGN\"},\n" +
			"    {\"Country\": \"Oman\", \"CountryCode\": \"OM\", \"Currency\": \"Sul Rial\", \"Code\": \"OMR\"},\n" +
			"    {\"Country\": \"Pakistan\", \"CountryCode\": \"PK\", \"Currency\": \"Rupee\", \"Code\": \"PKR\"},\n" +
			"    {\"Country\": \"Panama\", \"CountryCode\": \"PA\", \"Currency\": \"Balboa\", \"Code\": \"PAB\"},\n" +
			"    {\"Country\": \"Papua New Guinea\", \"CountryCode\": \"PG\", \"Currency\": \"Kina\", \"Code\": \"PGK\"},\n" +
			"    {\"Country\": \"Paraguay\", \"CountryCode\": \"PY\", \"Currency\": \"Guarani\", \"Code\": \"PYG\"},\n" +
			"    {\"Country\": \"Peru\", \"CountryCode\": \"PE\", \"Currency\": \"Nuevo Sol\", \"Code\": \"PEN\"},\n" +
			"    {\"Country\": \"Philippines\", \"CountryCode\": \"PH\", \"Currency\": \"Peso\", \"Code\": \"PHP\"},\n" +
			"    {\"Country\": \"Poland\", \"CountryCode\": \"PL\", \"Currency\": \"Zloty\", \"Code\": \"PLN\"},\n" +
			"    {\"Country\": \"Qatar\", \"CountryCode\": \"QA\", \"Currency\": \"Rial\", \"Code\": \"QAR\"},\n" +
			"    {\"Country\": \"Romania\", \"CountryCode\": \"RO\", \"Currency\": \"Leu\", \"Code\": \"RON\"},\n" +
			"    {\"Country\": \"Russian Federation\", \"CountryCode\": \"RU\", \"Currency\": \"Ruble\", \"Code\": \"RUB\"},\n" +
			"    {\"Country\": \"Rwanda\", \"CountryCode\": \"RW\", \"Currency\": \"Rwanda Franc\", \"Code\": \"RWF\"},\n" +
			"    {\"Country\": \"Sao Tome and Principe\", \"CountryCode\": \"ST\", \"Currency\": \"Dobra\", \"Code\": \"STD\"},\n" +
			"    {\"Country\": \"Saudi Arabia\", \"CountryCode\": \"SA\", \"Currency\": \"Riyal\", \"Code\": \"SAR\"},\n" +
			"    {\"Country\": \"Seychelles\", \"CountryCode\": \"SC\", \"Currency\": \"Rupee\", \"Code\": \"SCR\"},\n" +
			"    {\"Country\": \"Sierra Leone\", \"CountryCode\": \"SL\", \"Currency\": \"Leone\", \"Code\": \"SLL\"},\n" +
			"    {\"Country\": \"Singapore\", \"CountryCode\": \"SG\", \"Currency\": \"Dollar\", \"Code\": \"SGD\"},\n" +
			"    {\"Country\": \"Slovakia (Slovak Republic)\", \"CountryCode\": \"SK\", \"Currency\": \"Koruna\", \"Code\": \"SKK\"},\n" +
			"    {\"Country\": \"Solomon Islands\", \"CountryCode\": \"SB\", \"Currency\": \"Solomon Islands Dollar\", \"Code\": \"SBD\"},\n" +
			"    {\"Country\": \"Somalia\", \"CountryCode\": \"SO\", \"Currency\": \"Shilling\", \"Code\": \"SOS\"},\n" +
			"    {\"Country\": \"South Africa\", \"CountryCode\": \"ZA\", \"Currency\": \"Rand\", \"Code\": \"ZAR\"},\n" +
			"    {\"Country\": \"Sri Lanka\", \"CountryCode\": \"LK\", \"Currency\": \"Rupee\", \"Code\": \"LKR\"},\n" +
			"    {\"Country\": \"Sudan\", \"CountryCode\": \"SD\", \"Currency\": \"Dinar\", \"Code\": \"SDG\"},\n" +
			"    {\"Country\": \"Suriname\", \"CountryCode\": \"SR\", \"Currency\": \"Surinamese Guilder\", \"Code\": \"SRD\"},\n" +
			"    {\"Country\": \"Swaziland\", \"CountryCode\": \"SZ\", \"Currency\": \"Lilangeni\", \"Code\": \"SZL\"},\n" +
			"    {\"Country\": \"Sweden\", \"CountryCode\": \"SE\", \"Currency\": \"Krona\", \"Code\": \"SEK\"},\n" +
			"    {\"Country\": \"Syrian Arab Republic\", \"CountryCode\": \"SY\", \"Currency\": \"Syrian Pound\", \"Code\": \"SYP\"},\n" +
			"    {\"Country\": \"Taiwan\", \"CountryCode\": \"TW\", \"Currency\": \"Dollar\", \"Code\": \"TWD\"},\n" +
			"    {\"Country\": \"Tajikistan\", \"CountryCode\": \"TJ\", \"Currency\": \"Tajikistan Ruble\", \"Code\": \"TJS\"},\n" +
			"    {\"Country\": \"Tanzania\", \"CountryCode\": \"TZ\", \"Currency\": \"Shilling\", \"Code\": \"TZS\"},\n" +
			"    {\"Country\": \"Thailand\", \"CountryCode\": \"TH\", \"Currency\": \"Baht\", \"Code\": \"THB\"},\n" +
			"    {\"Country\": \"Tonga\", \"CountryCode\": \"TO\", \"Currency\": \"PaÕanga\", \"Code\": \"TOP\"},\n" +
			"    {\"Country\": \"Trinidad and Tobago\", \"CountryCode\": \"TT\", \"Currency\": \"Trinidad and Tobago Dollar\", \"Code\": \"TTD\"},\n" +
			"    {\"Country\": \"Tunisia\", \"CountryCode\": \"TN\", \"Currency\": \"Tunisian Dinar\", \"Code\": \"TND\"},\n" +
			"    {\"Country\": \"Turkey\", \"CountryCode\": \"TR\", \"Currency\": \"Lira\", \"Code\": \"TRY\"},\n" +
			"    {\"Country\": \"Turkmenistan\", \"CountryCode\": \"TM\", \"Currency\": \"Manat\", \"Code\": \"TMT\"},\n" +
			"    {\"Country\": \"Uganda\", \"CountryCode\": \"UG\", \"Currency\": \"Shilling\", \"Code\": \"UGX\"},\n" +
			"    {\"Country\": \"Ukraine\", \"CountryCode\": \"UA\", \"Currency\": \"Hryvnia\", \"Code\": \"UAH\"},\n" +
			"    {\"Country\": \"United Arab Emirates\", \"CountryCode\": \"AE\", \"Currency\": \"Dirham\", \"Code\": \"AED\"},\n" +
			"    {\"Country\": \"Uruguay\", \"CountryCode\": \"UY\", \"Currency\": \"Peso\", \"Code\": \"UYU\"},\n" +
			"    {\"Country\": \"Uzbekistan\", \"CountryCode\": \"UZ\", \"Currency\": \"Som\", \"Code\": \"UZS\"},\n" +
			"    {\"Country\": \"Vanuatu\", \"CountryCode\": \"VU\", \"Currency\": \"Vatu\", \"Code\": \"VUV\"},\n" +
			"    {\"Country\": \"Venezuela\", \"CountryCode\": \"VE\", \"Currency\": \"Bolivar\", \"Code\": \"VEF\"},\n" +
			"    {\"Country\": \"Vietnam\", \"CountryCode\": \"VN\", \"Currency\": \"Dong\", \"Code\": \"VND\"},\n" +
			"    {\"Country\": \"Yemen\", \"CountryCode\": \"YE\", \"Currency\": \"Rial\", \"Code\": \"YER\"},\n" +
			"    {\"Country\": \"Zambia\", \"CountryCode\": \"ZM\", \"Currency\": \"Kwacha\", \"Code\": \"ZMK\"},\n" +
			"    {\"Country\": \"Zimbabwe\", \"CountryCode\": \"ZW\", \"Currency\": \"Zimbabwe Dollar\", \"Code\": \"ZWD\"},\n" +
			"    {\"Country\": \"Aland Islands\", \"CountryCode\": \"AX\", \"Currency\": \"Euro\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Angola\", \"CountryCode\": \"AO\", \"Currency\": \"Angolan kwanza\", \"Code\": \"AOA\"},\n" +
			"    {\"Country\": \"Antarctica\", \"CountryCode\": \"AQ\", \"Currency\": \"Antarctican dollar\", \"Code\": \"AQD\"},\n" +
			"    {\"Country\": \"Bosnia and Herzegovina\", \"CountryCode\": \"BA\", \"Currency\": \"Bosnia and Herzegovina convertible mark\", \"Code\": \"BAM\"},\n" +
			"    {\"Country\": \"Congo (Kinshasa)\", \"CountryCode\": \"CD\", \"Currency\": \"Congolese Frank\", \"Code\": \"CDF\"},\n" +
			"    {\"Country\": \"Ghana\", \"CountryCode\": \"GH\", \"Currency\": \"Ghana cedi\", \"Code\": \"GHS\"},\n" +
			"    {\"Country\": \"Guernsey\", \"CountryCode\": \"GG\", \"Currency\": \"Guernsey pound\", \"Code\": \"GGP\"},\n" +
			"    {\"Country\": \"Isle of Man\", \"CountryCode\": \"IM\", \"Currency\": \"Manx pound\", \"Code\": \"GBP\"},\n" +
			"    {\"Country\": \"Laos\", \"CountryCode\": \"LA\", \"Currency\": \"Lao kip\", \"Code\": \"LAK\"},\n" +
			"    {\"Country\": \"Macao S.A.R.\", \"CountryCode\": \"MO\", \"Currency\": \"Macanese pataca\", \"Code\": \"MOP\"},\n" +
			"    {\"Country\": \"Montenegro\", \"CountryCode\": \"ME\", \"Currency\": \"Euro\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Palestinian Territory\", \"CountryCode\": \"PS\", \"Currency\": \"Jordanian dinar\", \"Code\": \"JOD\"},\n" +
			"    {\"Country\": \"Saint Barthelemy\", \"CountryCode\": \"BL\", \"Currency\": \"Euro\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Saint Helena\", \"CountryCode\": \"SH\", \"Currency\": \"Saint Helena pound\", \"Code\": \"GBP\"},\n" +
			"    {\"Country\": \"Saint Martin (French part)\", \"CountryCode\": \"MF\", \"Currency\": \"Netherlands Antillean guilder\", \"Code\": \"ANG\"},\n" +
			"    {\"Country\": \"Saint Pierre and Miquelon\", \"CountryCode\": \"PM\", \"Currency\": \"Euro\", \"Code\": \"EUR\"},\n" +
			"    {\"Country\": \"Serbia\", \"CountryCode\": \"RS\", \"Currency\": \"Serbian dinar\", \"Code\": \"RSD\"},\n" +
			"    {\"Country\": \"US Armed Forces\", \"CountryCode\": \"USAF\", \"Currency\": \"US Dollar\", \"Code\": \"USD\"}\n" +
			"]";
}
