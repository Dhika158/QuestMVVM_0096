package com.example.prak7.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    //edit 1 : parameter pilihanJK dan onSubmitButtonClicked
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    //edit 2 : tambahkan 4 variable dibawah ini
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    val listData: MutableList<String> = mutableListOf(txtNama, txtGender, txtAlamat)

    Scaffold(modifier = Modifier,
        (TopAppBar(title = { Text(stringResource(id = R.string.app_name), color = Color.white)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple_500))
        )
                ) { isiRuang ->

            Column(
                modifier = Modifier.padding(isiRuang),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //edit 3 : value, onValueChange, selected, onclick
                OutlinedTextField(
                    value = txtNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.width(250.dp).padding(top=28.dp),
                    label = { Text(text = "Nama Lengkap") },
                    onValueChange = {
                        txtNama = it
                    }
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(12.dp)
                        .width(250.dp),
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    color = Color.Blue
                )
                Row {
                    pilihanJK.forEach { item ->
                        Row(modifier = Modifier.selectable(
                            selected = txtGender == item,
                            onClick = {
                                txtGender = item
                            }
                        ),
                            verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = txtGender == item,
                                onClick = {
                                    txtGender = item
                                }
                            )
                            Text(item)
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(5.dp)
                        .width(250.dp),
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    color = Color.Blue
