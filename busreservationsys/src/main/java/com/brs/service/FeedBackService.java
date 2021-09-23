package com.brs.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.FeedBack;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.repository.IFeedBackRepository;

@Service
@Transactional
/**
 * Description:This is feedback Service Class that provides the services to add
 * a feedback, remove a feedback, update a feedback and view a feedback
 **/
public class FeedBackService implements IFeedBackService {
	@Autowired
	private IFeedBackRepository feedbackRepository;

	/**
	 * Description :To add FeedBack to the database Input Params :FeedBack object to
	 * be added to the database Return Value :FeedBack Object
	 **/

	@Override
	public FeedBack addFeedBack(FeedBack feedback) {
		feedbackRepository.save(feedback);

		return feedback;

	}

	/**
	 * Description :To update FeedBack in the database Input Params :FeedBack object
	 * to be added to the database Return Value :FeedBack Object
	 **/

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) {
		feedbackRepository.save(feedback);

		return feedback;

	}

	/**
	 * Description :To view FeedBack in the database Input Params :FeedBack id whose
	 * FeedBack object should be viewed in the database Return Value :FeedBack
	 * Object
	 **/

	@Override
	public FeedBack viewFeedBack(int id) {
		return feedbackRepository.findById(id).get();

	}

	/**
	 * Description :To view all the FeedBack in the database Return Value :list of
	 * FeedBack Objects
	 **/

	@Override
	public List<FeedBack> viewAllFeedBack() {

		return feedbackRepository.findAll();

	}

	/**
	 * Description :To delete FeedBack from the database Input Params :FeedBack
	 * object to be deleted from the database Return Value :FeedBack Object
	 * Exception :FeedBackNotFoundException-raised when FeedBack Id not found
	 **/
	@Override
	public FeedBack deleteFeedBack(int feedBackId) {
		FeedBack feedBack = null;
		try {
			feedBack = feedbackRepository.findById(feedBackId).orElseThrow(FeedBackNotFoundException::new);
			feedbackRepository.delete(feedBack);
		} catch (FeedBackNotFoundException e) {
			e.printStackTrace();
		}
		return feedBack;
	}

}
