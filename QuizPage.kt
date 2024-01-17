package com.example.quizzify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizzify.Class.QuestionModel
import com.example.quizzify.databinding.ActivityQuizPageBinding
import com.google.android.material.color.utilities.Score

class QuizPage : AppCompatActivity() {
    private lateinit var binding:ActivityQuizPageBinding
    private lateinit var list:ArrayList<QuestionModel>
    private var count:Int=0
    private var score:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuizPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        without using firebase cloud to fetch data
        list=ArrayList<QuestionModel>()
        list.add(QuestionModel("Who is the prime minister of Bharat","Shri Narendra Modi","Nitin Gatkari","Atal Bihari Vajpayi","A.P.G Abdul Kalam","Shri Narendra Modi"))
        list.add(QuestionModel("What is the economy of Bharat","3.1trillion","3.2trillion","3.3trillion","3.0trillion","3.0trillion"))
        list.add(QuestionModel("What is the population of Bharat","1.4billion","1.45billion","1.25billion","1.5billion","1.4billion"))
        list.add(QuestionModel("What is the National language of Bharat","Marathi","Punjabi","Bhojpuri","Hindi","Hindi"))

        binding.question.setText(list.get(0).Question)
        binding.option1.setText(list.get(0).option1)
        binding.option2.setText(list.get(0).option2)
        binding.option3.setText(list.get(0).option3)
        binding.option4.setText(list.get(0).option4)

//        binding.option1.setOnClickListener {
//            nextData(1)
//        }
//        binding.option2.setOnClickListener {
//            nextData(2)
//        }
//        binding.option3.setOnClickListener {
//            nextData(3)
//        }
//        binding.option4.setOnClickListener {
//            nextData(4)
//        }
        binding.option1.setOnClickListener {
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            nextData(binding.option4.text.toString())
        }


    }

    private fun nextData(i: String) {
        if(count<list.size){
            if(list.get(count).ans.equals(i)){
                score++
            }
        }
        count++
        if(count>=list.size){
//            Toast.makeText(this,score.toString(),Toast.LENGTH_LONG).show()
            val intent=Intent(this,ScorePage::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }else{
            binding.question.setText(list.get(count).Question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }

    }


}